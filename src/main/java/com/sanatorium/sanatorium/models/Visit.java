package com.sanatorium.sanatorium.models;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "VISITS")
@EnableAutoConfiguration
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Temporal(TemporalType.TIME)
    private LocalTime time;

    @OneToOne
    private User patient;

    @OneToOne
    private User doctor;

    @OneToOne @Column(nullable = true)
    private Referral referral;


}
