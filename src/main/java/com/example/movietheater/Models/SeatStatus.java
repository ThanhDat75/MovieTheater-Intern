package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "seatstatus")
@Getter
@Setter
public class SeatStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "namestatus")
    private String nameStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seatStatus")
    @JsonManagedReference(value = "seatStatus-seat")
    private Set<Seat> seatSet;
}
