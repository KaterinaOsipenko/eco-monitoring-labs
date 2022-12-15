package com.example.ecomonitoringlabs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "OBJECTS_LAB1")
@Setter
@Getter
public class ObjectProduction {
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

    private double value_pollution;

    private int factorError;

    private String events_for_reduction_pollution;


}
