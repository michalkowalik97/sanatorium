package com.sanatorium.sanatorium.models;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "REHABILITATIONS")
@EnableAutoConfiguration
public class Rehabilitation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(nullable = true)
    private String description;

    @Temporal(TemporalType.DATE)
    private LocalDate fromDate;

    @Temporal(TemporalType.TIME)
    private LocalTime fromTime;

    @Temporal(TemporalType.DATE)
    private LocalDate toDate;

    @Temporal(TemporalType.TIME)
    private LocalTime toTime;

    @OneToOne
    private User patient;

    @OneToOne
    private User doctor;

    @OneToOne
    @Column(nullable = true)
    private Referral referral;
}
