package com.sanatorium.sanatorium.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "ROOMS")
@EnableAutoConfiguration
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    private int floor;

    private int number;

    @Column(nullable = true)
    private String state;


}
