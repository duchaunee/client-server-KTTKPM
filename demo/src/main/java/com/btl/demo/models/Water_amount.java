package com.btl.demo.models;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Water_amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int amount;

    @Column
    private int customer_id;

    @Column
    private Date used_time;


    public Water_amount() {

    }

    public Water_amount(int amount, int customer_id, Date used_time) {
        this.amount = amount;
        this.customer_id = customer_id;
        this.used_time = used_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getUsed_time() {
        return used_time;
    }

    public void setUsed_time(Date used_time) {
        this.used_time = used_time;
    }
}

