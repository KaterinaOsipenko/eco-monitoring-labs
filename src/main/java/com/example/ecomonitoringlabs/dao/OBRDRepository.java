package com.example.ecomonitoringlabs.dao;

import com.example.ecomonitoringlabs.model.OBRD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OBRDRepository extends JpaRepository<OBRD, Long> {
}
