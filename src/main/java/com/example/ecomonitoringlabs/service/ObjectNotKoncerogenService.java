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

    @Autowired
    private ObjectNotKoncerogenRepository objectNotKoncerogenRepository;

    public List<Object_Not_Koncerogen> findAll() {
        List<Object_Not_Koncerogen> all = objectNotKoncerogenRepository.findAll();
        for (Object_Not_Koncerogen obj : all) {
            BigDecimal value = BigDecimal.valueOf(obj.getConcentration() / 365 / obj.getSubstance().getRfc().getRfc());
            obj.setHq(value.setScale(2, RoundingMode.FLOOR));
            objectNotKoncerogenRepository.save(obj);
        }
        return all;
    }
}
