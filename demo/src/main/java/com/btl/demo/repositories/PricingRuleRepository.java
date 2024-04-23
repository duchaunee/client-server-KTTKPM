package com.btl.demo.repositories;

import com.btl.demo.models.Pricing_rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


//extends từ JpaRepository thì nó có sẵn vài method: findAll, findById,....
@Repository
public interface PricingRuleRepository extends JpaRepository<Pricing_rule, Integer> {
//    @Query("SELECT p from Pricing_rule p")
//    List<Pricing_rule> findAll(Long pricing_ruleId);
}
