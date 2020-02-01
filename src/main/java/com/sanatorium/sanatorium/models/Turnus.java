package com.sanatorium.sanatorium.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TURNUSES")
@EnableAutoConfiguration
public class Turnus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate fromDate;

    @Temporal(TemporalType.TIME)
    private LocalTime fromTime;

    @Temporal(TemporalType.DATE)
    private LocalDate toDate;

    @Temporal(TemporalType.TIME)
    private LocalTime toTime;

    @OneToOne
    private Room room;

    @OneToOne
    private User patient;
}
