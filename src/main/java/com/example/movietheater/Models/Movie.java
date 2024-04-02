package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movieduration")
    private int movieDuration;

    @Column(name = "endtime")
    private LocalDateTime endTime;

    @Column(name = "premieredate")
    private LocalDateTime premiereDate;

    @Column(name = "description")
    private String description;

    @Column(name = "director")
    private String director;

    @Column(name = "image")
    private String image;

    @Column(name = "heroimage")
    private String heroImage;

    @Column(name = "language")
    private String language;

    @Column(name = "movietypeid")
    private int movieTypeID;

    @ManyToOne
    @JoinColumn(name = "movietypeid", insertable = false, updatable = false)
    @JsonBackReference(value = "movieType-movie")
    private MovieType movieType;

    @Column(name = "name")
    private String name;

    @Column(name = "rateid")
    private int rateID;

    @ManyToOne
    @JoinColumn(name = "rateid", insertable = false, updatable = false)
    @JsonBackReference(value = "rate-movie")
    private Rate rate;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    @JsonManagedReference(value = "movie-schedule")
    private Set<Schedule> scheduleSet;
}
