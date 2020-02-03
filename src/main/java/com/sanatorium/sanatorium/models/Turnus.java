package com.sanatorium.sanatorium.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "TURNUSES")
@EnableAutoConfiguration
public class Turnus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(nullable = true)
    public boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date toDateTime;

    @OneToOne
    private Room room;

    @OneToOne
    private User patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(Date fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public Date getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(Date toDateTime) {
        this.toDateTime = toDateTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public String getDateTimeInHtmlFormat(Date dateTime) {
        String date = dateTime.toString();
        date = date.substring(0,10)+"T"+date.substring(11,16);
        return date;
    }

    public String getDateTimeInUserFriendlyFormat(Date dateTime){
        String date = dateTime.toString();
        date = date.substring(0,10)+" Godz.: "+date.substring(11,16);
        return date;
    }

    public String getDateInUserFriendlyFormat(Date dateTime){
        String date = dateTime.toString();
        date = date.substring(0,10);//+" Godz.: "+date.substring(11,16);
        return date;
    }
}
