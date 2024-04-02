package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "refreshtoken")
@Getter
@Setter
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Token")
    private String token;

    @Column(name = "expiredtime")
    private LocalDateTime expiredTime;

    @Column(name = "userid")
    private int userID;

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    @JsonBackReference(value = "user-refreshToken")
    private User user;
}
