package com.btl.demo.controllers;

import com.btl.demo.models.Water_amount;
import com.btl.demo.repositories.WaterAmountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class WaterAmountController {

    @Autowired
    private WaterAmountRepository waterAmountRepository;


    //get a pricing rule (single)
    @PostMapping("/waterAmount/{id}")
    public Optional<Water_amount> getWaterAmount(@RequestParam int water_amount_id) {
        return waterAmountRepository.findById(water_amount_id);
    }
}
