package com.example.ecomonitoringlabs.dao;

import com.example.ecomonitoringlabs.model.ObjectProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

@Repository
public interface ObjectsProductionRepository extends JpaRepository<ObjectProduction, Double> {
}
