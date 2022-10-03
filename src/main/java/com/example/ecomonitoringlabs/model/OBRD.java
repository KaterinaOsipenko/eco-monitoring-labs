package com.example.ecomonitoringlabs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class OBRD {

    @Id
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_substance", nullable = false)
    private Substance substance;

    private double obrd_value;
}
