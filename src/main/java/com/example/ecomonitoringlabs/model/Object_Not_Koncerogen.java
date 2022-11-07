package com.example.ecomonitoringlabs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "OBJ_LAB3_NOT_KONCEROGEN")
public class Object_Not_Koncerogen {

    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_object", nullable = false)
    private ObjectFactory object;
    @ManyToOne
    @JoinColumn(name = "id_substance", nullable = false)
    private Substance substance;

    private double concentration;

    private BigDecimal hq;

    private int year;
}