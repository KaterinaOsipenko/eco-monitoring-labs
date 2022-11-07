package com.example.ecomonitoringlabs.dao;

import com.example.ecomonitoringlabs.model.Object_Not_Koncerogen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectNotKoncerogenRepository extends JpaRepository<Object_Not_Koncerogen, Integer> {
}
