package com.example.ecomonitoringlabs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class GDK {

    @Id
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_substance", nullable = false)
    private Substance substance;

    private double max_gdk;

    private double avg_gdk;

    private int dangerous_class;


}
