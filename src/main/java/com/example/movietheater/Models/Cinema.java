package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "cinema")
@Getter
@Setter
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "nameofcinema")
    private String nameOfCinema;

    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinema")
    @JsonManagedReference(value = "cinema-room")
    private Set<Room> roomSet;
}
