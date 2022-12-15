package com.example.ecomonitoringlabs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "OBJECTS_LAB2")
public class ObjectTax {

    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_object", nullable = false)
    private ObjectFactory object;
    @ManyToOne
    @JoinColumn(name = "id_substance", nullable = false)
    private Substance substance;

    private double concentration;

    private int year;

    private double amount_of_emissions;

    private double tax_rates_for_emissions;

    private BigDecimal tax_amount;
}
