package com.btl.demo.models;
import jakarta.persistence.*;

@Entity
public class Pricing_rule_water_amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int pricing_rule_id;

    @Column
    private int water_amount_id;


    public Pricing_rule_water_amount() {

    }

    public Pricing_rule_water_amount(int pricing_rule_id, int water_amount_id) {
        this.pricing_rule_id = pricing_rule_id;
        this.water_amount_id = water_amount_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPricing_rule_id() {
        return pricing_rule_id;
    }

    public void setPricing_rule_id(int pricing_rule_id) {
        this.pricing_rule_id = pricing_rule_id;
    }

    public int getWater_amount_id() {
        return water_amount_id;
    }

    public void setWater_amount_id(int water_amount_id) {
        this.water_amount_id = water_amount_id;
    }
}
