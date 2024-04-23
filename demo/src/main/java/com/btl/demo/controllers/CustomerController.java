package com.btl.demo.controllers;

import com.btl.demo.DTO.response.CustomerResponseDTO;
import com.btl.demo.models.Customer;
import com.btl.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //return CustomerResponseDTO de loai bo username, passwowrd trong Customer khi tra ve cho ng dung
    @GetMapping("/customer")
    public List<CustomerResponseDTO> getALlPricingRule() {
        List<Customer> c = customerRepository.findAll();
        List<CustomerResponseDTO> new_c_list= new ArrayList<>();

        for (int i = 0; i < c.size(); i++) {
            Customer current_c = c.get(i);
            CustomerResponseDTO new_c = new CustomerResponseDTO(
                    current_c.getId(),
                    current_c.getName(),
                    current_c.getAddress(),
                    current_c.getEmail(),
                    current_c.getPhone(),
                    current_c.getDob()
            );
            new_c_list.add(new_c);
        }
        return new_c_list;
    }
}
