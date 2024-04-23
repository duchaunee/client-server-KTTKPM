package com.btl.demo.repositories;

import com.btl.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e from Employee e WHERE e.username = :username AND e.password = :password")
    Employee login(@Param("username") String username, @Param("password") String password);
}

