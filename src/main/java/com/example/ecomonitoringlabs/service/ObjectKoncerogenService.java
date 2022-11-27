package com.example.ecomonitoringlabs.service;

import com.example.ecomonitoringlabs.dao.ObjectKoncerogenRepository;
import com.example.ecomonitoringlabs.model.Object_Koncerogen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ObjectKoncerogenService {
    private final static int TOUT = 8;
    private final static int TIN = 16;
    private final static double VOUT = 1.4;
    private final static double VIN = 0.63;
    private final static int EF = 350;
    private final static int ED = 30;
    private final static int BW = 70;
    private final static int ED_RISK = 70;
    private final static int AT = 70;
    private final static int EF_RISK = 365;
    private final static int POP = 300000;

    private final static double OSF = 0.84;
    private final static double IR = 0.4;

    private final static int K = 100;

    private final static int AT_RISK = 70 * 365 * 365;

    @Autowired
    private ObjectKoncerogenRepository objectKoncerogenRepository;

    public List<Object_Koncerogen> findAllRisk() {
        List<Object_Koncerogen> all = objectKoncerogenRepository.findAll();
        for (Object_Koncerogen obj : all) {
            obj.setRisk(caclRisk(obj));
        }
        return all;
    }

    private double caclRisk(Object_Koncerogen obj) {
        return 1 - Math.exp(((Math.log(OSF) / calcClim(obj)) + (Math.log(OSF) % calcClim(obj))) * calcLadd(obj));
    }

    private double calcLadd(Object_Koncerogen obj) {
        return obj.getConcentration() * IR * EF_RISK * ((ED_RISK / BW) + (ED_RISK % BW)) * AT_RISK;
    }

    private double calcClim(Object_Koncerogen obj) {
        return obj.getSubstance().getGdk().getMax_gdk() * K;
    }

    public List<Object_Koncerogen> findAllPollution() {
        List<Object_Koncerogen> all = objectKoncerogenRepository.findAll();
        for (Object_Koncerogen obj : all) {
            BigDecimal value = BigDecimal.valueOf(calcCR(obj) * POP / 1000000);
            obj.setPcr(value.setScale(2, RoundingMode.FLOOR));
            objectKoncerogenRepository.save(obj);
        }
        return all;
    }

    private double calcCR(Object_Koncerogen obj) {
        return calcLADD(obj) * obj.getSubstance().getSfi().getSfi();
    }

    private double calcLADD(Object_Koncerogen obj) {
        return ((obj.getConcentration() * TOUT * VOUT) + (obj.getConcentration() * TIN * VIN)) * EF * ED / (BW * AT * 365);
    }
}
