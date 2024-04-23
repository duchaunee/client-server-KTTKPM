package com.btl.demo.DTO.response;

import com.btl.demo.models.Employee;
import org.springframework.http.HttpStatus;

public class LoginResponseDTO {
    private Employee employee;
    private HttpStatus status;
    private String message;

    public LoginResponseDTO() {}

    public LoginResponseDTO(Employee employee, HttpStatus status, String message) {
        this.employee = employee;
        this.status = status;
        this.message = message;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
