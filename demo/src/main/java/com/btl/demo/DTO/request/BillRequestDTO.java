package com.btl.demo.DTO.request;

import com.btl.demo.models.Customer;
import com.btl.demo.models.Employee;
import com.btl.demo.models.Water_amount;
import java.util.Date;

public class BillRequestDTO {
    private int customer_id;
    private int employee_id;
    private String payment;

    public BillRequestDTO(int customer_id, int employee_id, String payment) {
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.payment = payment;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }


    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
