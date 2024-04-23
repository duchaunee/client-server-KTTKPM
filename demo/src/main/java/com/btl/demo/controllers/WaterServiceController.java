package com.btl.demo.controllers;

import com.btl.demo.models.Water_amount;
import com.btl.demo.models.Water_service;
import com.btl.demo.repositories.WaterAmountRepository;
import com.btl.demo.repositories.WaterServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class WaterServiceController {

    @Autowired
    private WaterServiceRepository waterServiceRepository;

    @GetMapping("/waterservice")
    public List<Water_service> getWaterAmount() {
        return waterServiceRepository.findAll();
    }
}
