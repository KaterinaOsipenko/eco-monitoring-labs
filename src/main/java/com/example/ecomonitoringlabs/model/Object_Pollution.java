package com.example.ecomonitoringlabs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "OBJECTS_POLLUTION")
public class Object_Pollution {

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

    private BigDecimal loss;
}

