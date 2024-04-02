package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "promotion")
@Getter
@Setter
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "percent")
    private int percent;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "type")
    private String type;

    @Column(name = "starttime")
    private LocalDateTime startTime;

    @Column(name = "endtime")
    private LocalDateTime endTime;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "isactive")
    private boolean isActive;

    @Column(name = "rankcustomerid")
    private int rankCustomerID;

    @ManyToOne
    @JoinColumn(name = "rankcustomerid", insertable = false, updatable = false)
    @JsonBackReference(value = "rankCustomer-promotion")
    private RankCustomer rankCustomer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
    @JsonManagedReference(value = "promotion-bill")
    private Set<Bill> billSet;
}
