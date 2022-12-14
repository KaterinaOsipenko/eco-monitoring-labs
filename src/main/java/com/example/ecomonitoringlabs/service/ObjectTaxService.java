package com.example.ecomonitoringlabs.service;

import com.example.ecomonitoringlabs.dao.ObjectTaxRepository;
import com.example.ecomonitoringlabs.model.ObjectTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ObjectTaxService {

    @Autowired
    private ObjectTaxRepository objectTaxRepository;

    public List<ObjectTax> findAll() {
        List<ObjectTax> objectTaxes = objectTaxRepository.findAll();
        for (ObjectTax tax : objectTaxes) {
            tax.setTax_amount(BigDecimal.valueOf(tax.getAmount_of_emissions() * tax.getTax_rates_for_emissions()));
            objectTaxRepository.save(tax);
        }
        return objectTaxes;
    }
}
