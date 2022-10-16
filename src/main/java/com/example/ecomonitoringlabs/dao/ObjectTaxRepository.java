package com.example.ecomonitoringlabs.dao;

import com.example.ecomonitoringlabs.model.ObjectTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectTaxRepository extends JpaRepository<ObjectTax, Integer> {
}
