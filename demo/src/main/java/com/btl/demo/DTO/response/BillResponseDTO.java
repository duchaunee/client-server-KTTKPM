package com.btl.demo.DTO.response;

import com.btl.demo.models.Customer;
import com.btl.demo.models.Employee;
import com.btl.demo.models.Water_amount;
import java.util.Date;

public class BillResponseDTO {
    private Customer customer;
    private Employee employee;
    private Water_amount water_amount;
    private String payment;
    private Date create_at;

    public BillResponseDTO(Customer customer, Employee employee, Water_amount water_amount, String payment, Date create_at) {
        this.customer = customer;
        this.employee = employee;
        this.water_amount = water_amount;
        this.payment = payment;
        this.create_at = create_at;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Water_amount getWater_amount() {
        return water_amount;
    }

    public void setWater_amount(Water_amount water_amount) {
        this.water_amount = water_amount;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
}
