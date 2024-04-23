package com.btl.demo.repositories;

import com.btl.demo.models.Bill;
import com.btl.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
//    @Query("SELECT b FROM Bill b WHERE YEAR(b.created_at) = :year AND MONTH(b.created_at) = :month")
    @Query("SELECT b FROM Bill b WHERE YEAR(b.created_at) = :year")
    List<Bill> findBillsByMonth(@Param("year") String year);
}

