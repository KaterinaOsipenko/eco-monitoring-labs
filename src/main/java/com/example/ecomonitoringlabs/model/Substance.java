package com.example.ecomonitoringlabs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Substance {

    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "substance")
    private List<ObjectProduction> production;

    @OneToMany(mappedBy = "substance")
    private List<ObjectTax> taxes;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "substance")
    private OBRD obrd;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "substance")
    private GDK gdk;
}
