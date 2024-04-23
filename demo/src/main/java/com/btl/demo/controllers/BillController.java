package com.btl.demo.controllers;

import com.btl.demo.DTO.IPricingRuleWaterAmounResponse;
import com.btl.demo.DTO.request.BillRequestDTO;
import com.btl.demo.DTO.response.RevenueDTO;
import com.btl.demo.models.Bill;
import com.btl.demo.models.Pricing_rule;
import com.btl.demo.models.Pricing_rule_water_amount;
import com.btl.demo.models.Water_amount;
import com.btl.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private WaterAmountRepository waterAmountRepository;

    @Autowired
    private PricingRuleRepository pricingRuleRepository;

    @Autowired
    private PricingRuleWaterAmountRepository pricingRuleWaterAmountRepository;

    //get a pricing rule (single)
    @PostMapping("/insert/bill")
    public Bill insertBill(@RequestBody BillRequestDTO billRequestDTO) {
        int customer_id = billRequestDTO.getCustomer_id();
        int employee_id = billRequestDTO.getEmployee_id();
        String payment = billRequestDTO.getPayment();

        //get "SELECT a FROM Water_amount a WHERE a.customer_id = :customer_id ORDER BY a.used_time DESC LIMIT 1 (newest)"
        //lấy ra water_amount (số nước)  từ customer đó (Cái này là do chắc sẽ có người đi gõ cửa gần cuối tháng để thu thập)
        Water_amount w_neast = waterAmountRepository.getNeastTimeByCustomerId(customer_id);

        if (w_neast != null) {
            System.out.println("=======================================");
            System.out.println();
            System.out.println();
            System.out.println();

            Bill b = new Bill(
                    payment,
                    new Date(),
                    employee_id,
                    customer_id,
                    w_neast.getId()
            );
            billRepository.save(b);
            /**
             * phải xoá water_amount của customer đó đi nữa
             * waterAmountRepository.deleteById(w_neast.getId());
             */
            //
            return b;
        }
        return null;
    }

    /**
     * lấy ra doanh thu từ Bill
     * 1 Bill --> Trả về 1 RevenueDTO gồm:
     * -- time: Thời gian tạo Bill đó
     * -- total_water: Tổng số nước Bill của Bill đó
     * -- total_money: Tổng số tiền phải trả của Bill đó
     *
     * chung quy lại là vẫn phải tính tổng số tiền phải trả của Bill
     * tại sao lúc tạo Bill k thêm cái field total_money vào nhỉ =))))))))))
     * Nếu thêm vào thì chỉ cần sửa lại chỗ insert Bill, phải tính thêm total Money như bên dưới
     * Cũng k khác lắm nhỉ :V
     */
    @GetMapping("/revenue")
    public List<RevenueDTO> getRevenueByMonth() {
//        if (year == null) {
//            // Nếu không có tham số year được truyền vào, gán giá trị mặc định là năm hiện tại
//            year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
//        }
//        System.out.println("Year: " + year);
        //

        List <RevenueDTO> list_Revenue = new ArrayList<>(); //save result
        List<Bill> list_bill = (List<Bill>) billRepository.findAll();


        // Đối với mỗi Bill thì xử lý và trả về time (tgian) + total_water (tổng số nước) + total_money (tổng tiền)
        //check postman để thấy form trả về
        for (Bill bill : list_bill) {
            System.out.println("============");
            System.out.println(bill.getCreated_at());

            //lấy ra water_amount_id từ 1 Bill
            int water_amount_id = bill.getWater_amount_id();
            Water_amount water_amount = waterAmountRepository.getById(water_amount_id);
            System.out.println(water_amount_id);

            // Từ water_amount_id lấy ra LIST CÁC Pricing_rule_water_amount chứa water_amount_id đó
            List <Pricing_rule_water_amount> list_pricing_rule_water_amount = pricingRuleWaterAmountRepository.findBillsByWater_amount_id(water_amount_id);

            List<Pricing_rule> list_pricing_rule = new ArrayList<>();
            for (Pricing_rule_water_amount pricingRuleWaterAmount : list_pricing_rule_water_amount) {
                System.out.println(pricingRuleWaterAmount.getPricing_rule_id());
                list_pricing_rule.add(
                        pricingRuleRepository.getById(pricingRuleWaterAmount.getPricing_rule_id())
                );
            }

            /**
             * Ví dụ water_amount là 50 số thì nó
             * phải đi liền với 1 list pricing_rule (10-20: 2000vnd, 20-30: 3000vnd, 30-50: 4000vnd)
             * IPricingRuleWaterAmounResponse chứa:
             * -- 1 Water_amount waterAmount
             * -- 1 List<Pricing_rule> pricingRule
             */
            IPricingRuleWaterAmounResponse pricingRuleWaterAmounResponse = new IPricingRuleWaterAmounResponse(
                    water_amount,
                    list_pricing_rule
            );

            double total = 0;
            /**
             * p ricing_rule trong pricingRuleWaterAmounResponse.getListPricingRule() trong db phải được sort tăng dần theo các khoảng nhé =)))
             * lúc tạo thì tự sort nhé
             */
            for (Pricing_rule pricing_rule : pricingRuleWaterAmounResponse.getListPricingRule()) {
                int water_used = water_amount.getAmount();
                if (water_used > pricing_rule.getMax_usage()) {
                    total = pricing_rule.getMax_usage() * pricing_rule.getPrice();
                    water_used -= pricing_rule.getMax_usage();
                }
                else {
                    total = water_used * pricing_rule.getPrice();
                }
                System.out.println("Total: " + String.valueOf(total));

                //RESULT
                list_Revenue.add(
                        new RevenueDTO(
                                bill.getCreated_at(),
                                water_amount.getAmount(),
                                total
                        )
                );
            }
        }
        //
        return list_Revenue;
    }
}

