package com.btl.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column
    private String payment;

    @Column
    private Date created_at;

    @Column
    private int employee_id;

    @Column
    private int customer_id;

    @Column
    private int water_amount_id;

    public Bill() {
    }

    public Bill(String payment, Date created_at, int employee_id, int customer_id, int water_amount_id) {
        this.payment = payment;
        this.created_at = created_at;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.water_amount_id = water_amount_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getWater_amount_id() {
        return water_amount_id;
    }

    public void setWater_amount_id(int water_amount_id) {
        this.water_amount_id = water_amount_id;
    }
}
