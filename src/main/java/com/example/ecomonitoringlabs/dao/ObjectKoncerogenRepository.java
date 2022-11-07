package com.example.ecomonitoringlabs.dao;

import com.example.ecomonitoringlabs.model.Object_Koncerogen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectKoncerogenRepository extends JpaRepository<Object_Koncerogen, Integer> {
}
