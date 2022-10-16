package com.example.ecomonitoringlabs.service;

import com.example.ecomonitoringlabs.dao.ObjectsProductionRepository;
import com.example.ecomonitoringlabs.model.ObjectProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectProductionService {

    @Autowired
    private ObjectsProductionRepository objectsRepository;

    public List<ObjectProduction> findAll() {

        List<ObjectProduction> objectProductions = objectsRepository.findAll();
        for (ObjectProduction production : objectProductions) {
            if (production.getValue_pollution() > production.getSubstance().getGdk().getMax_gdk()) {
                int diff = (int) (production.getValue_pollution() / production.getSubstance().getGdk().getMax_gdk());
                production.setFactorError(diff * 100 - 100);
                objectsRepository.save(production);
            }
        }
        return objectProductions;
    }
}
