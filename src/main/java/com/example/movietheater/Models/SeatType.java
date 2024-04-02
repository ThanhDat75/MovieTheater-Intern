package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "seattype")
@Getter
@Setter
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nametype")
    private String nameType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seatType")
    @JsonManagedReference(value = "seatType-seat")
    private Set<Seat> seatSet;
}
