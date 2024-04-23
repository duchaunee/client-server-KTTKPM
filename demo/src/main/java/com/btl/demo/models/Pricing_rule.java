package com.btl.demo.models;

import jakarta.persistence.*;

@Entity
public class Pricing_rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int min_usage;

    @Column
    private int max_usage;

    @Column
    private double price;

    @Column
    private int water_service_id;


    public Pricing_rule() {

    }

    public Pricing_rule(int min_usage, int max_usage, double price, int water_service_id) {
        this.min_usage = min_usage;
        this.max_usage = max_usage;
        this.price = price;
        this.water_service_id = water_service_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMin_usage() {
        return min_usage;
    }

    public void setMin_usage(int min_usage) {
        this.min_usage = min_usage;
    }

    public int getMax_usage() {
        return max_usage;
    }

    public void setMax_usage(int max_usage) {
        this.max_usage = max_usage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWater_service_id() {
        return water_service_id;
    }

    public void setWater_service_id(int water_service_id) {
        this.water_service_id = water_service_id;
    }
}
