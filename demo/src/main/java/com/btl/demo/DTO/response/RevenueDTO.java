package com.btl.demo.DTO.response;

import com.btl.demo.models.Customer;
import com.btl.demo.models.Employee;
import com.btl.demo.models.Water_amount;

import java.util.Date;

public class RevenueDTO {
    private Date time;
    private int total_water;
    private double total_money;

    public RevenueDTO(Date time, int total_water, double total_money) {
        this.time = time;
        this.total_water = total_water;
        this.total_money = total_money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getTotal_water() {
        return total_water;
    }

    public void setTotal_water(int total_water) {
        this.total_water = total_water;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }
}
