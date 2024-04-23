package com.btl.demo.DTO.response;

import com.btl.demo.models.Pricing_rule;
import org.springframework.http.HttpStatus;

public class PricingRuleResponseDTO {

    private Object pricing_rule;
    private HttpStatus status;
    private String message;

    public PricingRuleResponseDTO(Object pricing_rule, HttpStatus status, String message) {
        this.pricing_rule = pricing_rule;
        this.status = status;
        this.message = message;
    }

    public Object getPricing_rule() {
        return pricing_rule;
    }

    public void setPricing_rule(Pricing_rule pricing_rule) {
        this.pricing_rule = pricing_rule;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
