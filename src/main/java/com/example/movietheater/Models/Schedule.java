package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "schedule")
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price")
    private double price;

    @Column(name = "startat")
    private LocalDateTime startAt;

    @Column(name = "endAt")
    private LocalDateTime endAt;

    @Column(name = "code")
    private String code;

    @Column(name = "movieid")
    private int movieID;

    @ManyToOne
    @JoinColumn(name = "movieid", insertable = false, updatable = false)
    @JsonBackReference(value = "movie-schedule")
    private Movie movie;

    @Column(name = "name")
    private String name;

    @Column(name = "roomid")
    private int roomID;

    @ManyToOne
    @JoinColumn(name = "roomid", insertable = false, updatable = false)
    @JsonBackReference(value = "room-schedule")
    private Room room;

    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schedule")
    @JsonManagedReference(value = "schedule-ticket")
    private Set<Ticket> ticketSet;
}
