package com.example.ecomonitoringlabs.dao;

import com.example.ecomonitoringlabs.model.ObjectProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectsProductionRepository extends JpaRepository<ObjectProduction, Double> {
}
