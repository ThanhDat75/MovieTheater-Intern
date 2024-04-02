package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "movietype")
@Getter
@Setter
public class MovieType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movietypename")
    private String movieTypeName;

    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieType")
    @JsonManagedReference(value = "movieType-movie")
    private Set<Movie> movieSet;
}
