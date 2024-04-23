package com.btl.demo.repositories;

import com.btl.demo.models.Water_amount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterAmountRepository extends JpaRepository<Water_amount, Integer> {
    @Query("SELECT a FROM Water_amount a WHERE a.customer_id = :customer_id ORDER BY a.used_time DESC LIMIT 1")
    Water_amount getNeastTimeByCustomerId(@Param("customer_id") int customer_id);

//    @Query("SELECT w FROM Water_amount w WHERE w.customerId = :customerId")
//    Water_amount findByCustomerId(@Param("customerid") Long customerId);
}

