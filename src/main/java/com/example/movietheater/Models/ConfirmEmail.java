package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "confirmemail")
@Getter
@Setter
public class ConfirmEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userid")
    private int userID;

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    @JsonBackReference(value = "user-confirmEmail")
    private User user;

    @Column(name = "expiredtime")
    private LocalDateTime expiredTime;

    @Column(name = "confirmcode")
    private String confirmCode;

    @Column(name = "isconfirm")
    private boolean isConfirm;
}
