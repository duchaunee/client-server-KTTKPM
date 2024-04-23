package com.btl.demo.controllers;

import com.btl.demo.DTO.request.LoginRequestDTO;
import com.btl.demo.DTO.response.LoginResponseDTO;
import com.btl.demo.models.Employee;
import com.btl.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/user")
    //get info employee from
    public List getUser() {
        return List.of("hau", "mai");
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        //get info employee from username + password
        Employee employee = employeeRepository.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());

        HttpStatus status = employee == null ? HttpStatus.NOT_IMPLEMENTED : HttpStatus.OK;
        String message = employee == null ? "username or password is incorrect" : "Login successfully !";

        return new LoginResponseDTO(employee, status, message);
    }
}
