package com.example.ecomonitoringlabs.dao;

import com.example.ecomonitoringlabs.model.Substance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubstanceRepository extends JpaRepository<Substance, Long> {
}
