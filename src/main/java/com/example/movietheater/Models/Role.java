package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "rolename")
    private String roleName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @JsonManagedReference(value = "role-user")
    private Set<User> userSet;
}
