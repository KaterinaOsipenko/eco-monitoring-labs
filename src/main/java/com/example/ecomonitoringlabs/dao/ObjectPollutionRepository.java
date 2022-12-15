package com.example.ecomonitoringlabs.dao;

import com.example.ecomonitoringlabs.model.Object_Pollution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectPollutionRepository extends JpaRepository<Object_Pollution, Long> {
}
