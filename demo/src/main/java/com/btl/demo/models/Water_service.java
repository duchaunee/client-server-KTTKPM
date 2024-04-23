package com.btl.demo.models;

import jakarta.persistence.*;

@Entity
public class Water_service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increament
    private int id;
    @Column
    private String service_name;

    public Water_service(String service_name) {
        this.service_name = service_name;
    }

    public Water_service() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
}

