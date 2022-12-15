package com.example.ecomonitoringlabs.service;

import com.example.ecomonitoringlabs.dao.ObjectPollutionRepository;
import com.example.ecomonitoringlabs.model.Object_Pollution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ObjectPollutionService {

    private final static int T = 8;

    @Autowired
    private ObjectPollutionRepository repository;

    public List<Object_Pollution> findAllLoss() {
        List<Object_Pollution> all = repository.findAll();
        for (Object_Pollution obj : all) {
            BigDecimal loss = BigDecimal.valueOf(getMI(obj) * 1.1 * 10000 * 1.8 * getA(obj) * getK(obj));
            obj.setLoss(loss.setScale(2, RoundingMode.FLOOR));
            repository.save(obj);
        }
        return all;
    }

    private double getK(Object_Pollution obj) {
        return obj.getConcentration() / obj.getSubstance().getGdk().getAvg_gdk();
    }

    private double getA(Object_Pollution obj) {
        return 1 / obj.getSubstance().getGdk().getAvg_gdk();
    }

    private double getMI(Object_Pollution obj) {
        return 3.6 * Math.pow(10, -3) * (getQMI(obj) - getQMNORM(obj)) * T;
    }

    private double getQMNORM(Object_Pollution obj) {
        int classGDK = obj.getSubstance().getGdk().getDangerous_class();
        if (classGDK == 1) {
            return 100;
        } else if (classGDK == 2) {
            return 2000;
        } else {
            return 2500;
        }
    }

    private double getQMI(Object_Pollution obj) {
        return obj.getAmount_of_emissions() * 1000 * 1000 * (365 * 24 * 60 * 60);
    }
}
