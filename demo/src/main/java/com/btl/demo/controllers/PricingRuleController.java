package com.btl.demo.controllers;

import com.btl.demo.DTO.IPricingRuleResponse;
import com.btl.demo.DTO.request.LoginRequestDTO;
import com.btl.demo.DTO.request.PricingRuleRequestDTO;
import com.btl.demo.DTO.response.LoginResponseDTO;
import com.btl.demo.DTO.response.PricingRuleResponseDTO;
import com.btl.demo.models.*;
import com.btl.demo.models.IResponse.ResponseObject;
import com.btl.demo.repositories.EmployeeRepository;
import com.btl.demo.repositories.PricingRuleRepository;
import com.btl.demo.repositories.WaterAmountRepository;
import com.btl.demo.repositories.WaterServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PricingRuleController {
    @Autowired
    private WaterServiceRepository waterServiceRepository;

    @Autowired
    private PricingRuleRepository pricingRuleRepository;


    //get all pricing rule
    @GetMapping("/pricingRule")
    public List<IPricingRuleResponse> getALlPricingRule() {
        List <Pricing_rule> list_p = pricingRuleRepository.findAll();
        List<IPricingRuleResponse> l = new ArrayList<>();

        for (int i = 0; i < list_p.size(); i++) {
            int water_service_id = list_p.get(i).getWater_service_id();
            l.add(new IPricingRuleResponse(
                    list_p.get(i).getId(),
                    list_p.get(i).getMin_usage(),
                    list_p.get(i).getMax_usage(),
                    list_p.get(i).getPrice(),
                    waterServiceRepository.findById(water_service_id)
            ));
        }
        return l;
    }

    //get a pricing rule (single)
    @GetMapping("/pricingRule/{id}")
    public PricingRuleResponseDTO getALlPricingRule(@PathVariable Integer id) {
        Optional<Pricing_rule> p = pricingRuleRepository.findById(id);
        if (p.isPresent()) {
            return new PricingRuleResponseDTO(p, HttpStatus.OK, "get a pricing rule successfully");
        }
        return new PricingRuleResponseDTO(null, HttpStatus.NOT_IMPLEMENTED, "pricing rule is not exist");
    }


    //insert pricing rule
    @PostMapping("/insertPricingRule")
    public PricingRuleResponseDTO insertPricingRule(@RequestBody PricingRuleRequestDTO pricingRuleRequestDTO) {
        Pricing_rule p = new Pricing_rule(
                pricingRuleRequestDTO.getMin_usage(),
                pricingRuleRequestDTO.getMax_usage(),
                pricingRuleRequestDTO.getPrice(),
                pricingRuleRequestDTO.getWater_service_id()
        );
        pricingRuleRepository.save(p);
        return new PricingRuleResponseDTO(p, HttpStatus.OK, "insert successfully");
    }

    //update pricing rule
    @PutMapping("/updatePricingRule/{id}")
    public PricingRuleResponseDTO insertPricingRule(@PathVariable Integer id, @RequestBody PricingRuleRequestDTO pricingRuleRequestDTO) {
        Optional<Pricing_rule> p_update = pricingRuleRepository.findById(id)
                .map(p -> {
                    p.setMin_usage(pricingRuleRequestDTO.getMin_usage());
                    p.setMax_usage(pricingRuleRequestDTO.getMax_usage());
                    p.setPrice(pricingRuleRequestDTO.getPrice());
                    p.setWater_service_id(pricingRuleRequestDTO.getWater_service_id());
                    return pricingRuleRepository.save(p);
                });
        return new PricingRuleResponseDTO(p_update, HttpStatus.OK, "Update successfully");
    }

    //update pricing rule
    @DeleteMapping("/deletePricingRule/{id}")
    public PricingRuleResponseDTO insertPricingRule(@PathVariable Integer id) {
        Optional<Pricing_rule> p = pricingRuleRepository.findById(id);
        if(p.isPresent()) {
            pricingRuleRepository.deleteById(id);
            return new PricingRuleResponseDTO(null, HttpStatus.OK, "Delete successfully");
        }
        return new PricingRuleResponseDTO(null, HttpStatus.NOT_IMPLEMENTED, "Delete Failed");
    }
}
