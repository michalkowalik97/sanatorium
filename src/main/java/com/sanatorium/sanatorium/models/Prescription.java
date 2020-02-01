package com.sanatorium.sanatorium.models;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRESCRIPTIONS")
@EnableAutoConfiguration
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @OneToMany
    private List<Medicament> medicament;

    @OneToOne
    private Visit visit;


}
