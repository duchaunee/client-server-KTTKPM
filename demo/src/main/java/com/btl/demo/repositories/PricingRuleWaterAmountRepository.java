package com.btl.demo.repositories;

import com.btl.demo.models.Bill;
import com.btl.demo.models.Pricing_rule;
import com.btl.demo.models.Pricing_rule_water_amount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//extends từ JpaRepository thì nó có sẵn vài method: findAll, findById,....
@Repository
public interface PricingRuleWaterAmountRepository extends JpaRepository<Pricing_rule_water_amount, Integer> {
    @Query("SELECT p FROM Pricing_rule_water_amount p WHERE p.water_amount_id = :water_amount_id")
    List<Pricing_rule_water_amount> findBillsByWater_amount_id(@Param("water_amount_id") int water_amount_id);
}
