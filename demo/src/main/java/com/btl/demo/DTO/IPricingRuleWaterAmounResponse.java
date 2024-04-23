package com.btl.demo.DTO;

import com.btl.demo.models.Pricing_rule;
import com.btl.demo.models.Water_amount;

import java.util.List;

public class IPricingRuleWaterAmounResponse {
    private Water_amount waterAmount;
    private List<Pricing_rule> pricingRule;

    public IPricingRuleWaterAmounResponse() {}

    public IPricingRuleWaterAmounResponse(Water_amount waterAmount, List<Pricing_rule> pricingRule) {
        this.waterAmount = waterAmount;
        this.pricingRule = pricingRule;
    }

    public Water_amount getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(Water_amount waterAmount) {
        this.waterAmount = waterAmount;
    }

    public List<Pricing_rule> getListPricingRule() {
        return pricingRule;
    }

    public void setPricingRule(List<Pricing_rule> pricingRule) {
        this.pricingRule = pricingRule;
    }
}

