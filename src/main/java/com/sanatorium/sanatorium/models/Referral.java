package com.sanatorium.sanatorium.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "REFERRAL")
@EnableAutoConfiguration
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    private String service;

    @Column(nullable = true )
    private String decription;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Temporal(TemporalType.TIME)
    private LocalTime time;

    @OneToOne
    private User patient;

    @OneToOne
    private User doctor;

}
