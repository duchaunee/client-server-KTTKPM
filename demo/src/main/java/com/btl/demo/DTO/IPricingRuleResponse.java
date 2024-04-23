package com.btl.demo.DTO;

import com.btl.demo.models.Water_service;

import java.util.Optional;

public class IPricingRuleResponse {
    private int id;

    private int min_usage;

    private int max_usage;

    private double price;

    private Optional<Water_service> water_service;

    public IPricingRuleResponse(int id, int min_usage, int max_usage, double price, Optional<Water_service> water_service) {
        this.id = id;
        this.min_usage = min_usage;
        this.max_usage = max_usage;
        this.price = price;
        this.water_service = water_service;
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

    public Optional<Water_service> getWater_service() {
        return water_service;
    }

    public void setWater_service(Optional<Water_service> water_service) {
        this.water_service = water_service;
    }
}
