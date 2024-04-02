package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "rankcustomer")
@Getter
@Setter
public class RankCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "point")
    private int point;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rankCustomer")
    @JsonManagedReference(value = "rankCustomer-promotion")
    private Set<Promotion> promotionSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rankCustomer")
    @JsonManagedReference(value = "rankCustomer-user")
    private Set<User> userSet;
}
