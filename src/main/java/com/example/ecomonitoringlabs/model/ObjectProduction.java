package com.example.ecomonitoringlabs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "objects")
@Setter
@Getter
public class ObjectProduction {

    @Id
    private double id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "id_substance", nullable = false)
    private Substance substance;

    private double value_pollution;

    private String events_for_reduction_pollution;


}
