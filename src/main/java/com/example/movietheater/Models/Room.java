package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "room")
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "type")
    private int type;

    @Column(name = "description")
    private String description;

    @Column(name = "cinemaid")
    private int cinemaID;

    @ManyToOne
    @JoinColumn(name = "cinemaid", insertable = false, updatable = false)
    @JsonBackReference(value = "cinema-room")
    private Cinema cinema;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    @JsonManagedReference(value = "room-schedule")
    private Set<Schedule> scheduleSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    @JsonManagedReference(value = "room-seat")
    private Set<Seat> seatSet;
}
