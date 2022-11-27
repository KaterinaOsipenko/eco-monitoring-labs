package com.example.ecomonitoringlabs.service;

import com.example.ecomonitoringlabs.dao.ObjectNotKoncerogenRepository;
import com.example.ecomonitoringlabs.model.Object_Not_Koncerogen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ObjectNotKoncerogenService {

    private final static int ED_RISK = 70;
    private final static double OSF = 0.84;
    private final static double IR = 0.4;
    private final static int EF_RISK = 365;
    private final static int K = 100;
    private final static int AT_RISK = 365 * 365;
    private final static int BW = 70;
    @Autowired
    private ObjectNotKoncerogenRepository objectNotKoncerogenRepository;

    public List<Object_Not_Koncerogen> findAllRisk() {
        List<Object_Not_Koncerogen> all = objectNotKoncerogenRepository.findAll();
        for (Object_Not_Koncerogen obj : all) {
            obj.setRisk(caclRisk(obj));
        }
        return all;
    }

    private double caclRisk(Object_Not_Koncerogen obj) {
        return 1 - Math.exp(Math.log(OSF) / calcClim(obj) * calcLadd(obj));
    }

    private double calcLadd(Object_Not_Koncerogen obj) {
        return obj.getConcentration() * IR * EF_RISK * (ED_RISK / BW) * AT_RISK;
    }

    private double calcClim(Object_Not_Koncerogen obj) {
        return obj.getSubstance().getGdk().getMax_gdk() * K;
    }

    public List<Object_Not_Koncerogen> findAllPollution() {
        List<Object_Not_Koncerogen> all = objectNotKoncerogenRepository.findAll();
        for (Object_Not_Koncerogen obj : all) {
            BigDecimal value = BigDecimal.valueOf(obj.getConcentration() / 365 / obj.getSubstance().getRfc().getRfc());
            obj.setHq(value.setScale(2, RoundingMode.FLOOR));
            objectNotKoncerogenRepository.save(obj);
        }
        return all;
    }
}
