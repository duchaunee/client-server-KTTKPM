package com.btl.demo.repositories;

import com.btl.demo.models.Water_service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterServiceRepository extends JpaRepository<Water_service, Integer> {
//    @Query("SELECT w FROM Water_amount w WHERE w.customerId = :customerId")
//    Water_amount findByCustomerId(@Param("customerid") Long customerId);
}

