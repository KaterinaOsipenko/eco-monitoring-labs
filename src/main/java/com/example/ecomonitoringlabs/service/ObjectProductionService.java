package com.example.ecomonitoringlabs.service;

import com.example.ecomonitoringlabs.dao.ObjectsProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectProductionService {

    @Autowired
    private ObjectsProductionRepository objectsRepository;
}
