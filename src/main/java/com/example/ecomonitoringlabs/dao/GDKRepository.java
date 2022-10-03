package com.example.ecomonitoringlabs.dao;

import com.example.ecomonitoringlabs.model.GDK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GDKRepository extends JpaRepository<GDK, Long> {
}
