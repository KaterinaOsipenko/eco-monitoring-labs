package com.example.ecomonitoringlabs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "objects")
public class ObjectFactory {

    @Id
    private double id;

    private String name;

    @OneToMany(mappedBy = "object")
    private List<ObjectProduction> production;

    @OneToMany(mappedBy = "object")
    private List<ObjectTax> taxes;

    @OneToMany(mappedBy = "object")
    private List<Object_Koncerogen> object_koncerogens;

    @OneToMany(mappedBy = "object")
    private List<Object_Not_Koncerogen> object_not_koncerogens;
}
