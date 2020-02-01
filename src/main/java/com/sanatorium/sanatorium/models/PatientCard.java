package com.sanatorium.sanatorium.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "PATEINTCARDS")
@EnableAutoConfiguration
public class PatientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(nullable = true)
    private String description;

    @OneToOne
    private Visit visit;

    @OneToOne @Column(nullable = true)
    private Prescription prescription;

    @OneToOne
    private User patient;

    @OneToOne @Column(nullable = true)
    private Referral referral;

}
