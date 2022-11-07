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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "substance")
    private SFI sfi;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "substance")
    private RFC rfc;

    @OneToMany(mappedBy = "substance")
    private List<ObjectProduction> production;

    @OneToMany(mappedBy = "substance")
    private List<ObjectTax> taxes;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "substance")
    private OBRD obrd;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "substance")
    private GDK gdk;

    @OneToMany(mappedBy = "substance")
    private List<Object_Not_Koncerogen> object_not_koncerogens;

    @OneToMany(mappedBy = "substance")
    private List<Object_Koncerogen> object_koncerogen;


}
