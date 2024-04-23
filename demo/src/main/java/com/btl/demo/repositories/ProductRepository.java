package com.btl.demo.repositories;

import com.btl.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository<entity's name, Primary key's type>
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(@Param("productName") String productName);
}
