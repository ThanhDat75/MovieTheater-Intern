package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "point")
    private int point;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String eMail;

    @Column(name = "name")
    private String name;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "rankcustomerid")
    private int rankCustomerID;

    @ManyToOne
    @JoinColumn(name = "rankcustomerid", insertable = false, updatable = false)
    @JsonBackReference(value = "rankCustomer-user")
    private RankCustomer rankCustomer;

    @Column(name = "userstatusid")
    private int userStatusID;

    @ManyToOne
    @JoinColumn(name = "userstatusid", insertable = false, updatable = false)
    @JsonBackReference(value = "userStatus-user")
    private UserStatus userStatus;

    @Column(name = "isactive")
    private boolean isActive;

    @Column(name = "roleid")
    private int roleID;

    @ManyToOne
    @JoinColumn(name = "roleid", insertable = false, updatable = false)
    @JsonBackReference(value = "role-user")
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JsonManagedReference(value = "user-bill")
    private Set<Bill> billSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JsonManagedReference(value = "user-confirmEmail")
    private Set<ConfirmEmail> confirmEmailSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JsonManagedReference(value = "user-refreshToken")
    private Set<RefreshToken> refreshTokenSet;
}
