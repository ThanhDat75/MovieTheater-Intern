package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "scheduleid")
    private int scheduleID;

    @ManyToOne
    @JoinColumn(name = "scheduleid", insertable = false, updatable = false)
    @JsonBackReference(value = "schedule-ticket")
    private Schedule schedule;

    @Column(name = "seatid")
    private int seatID;

    @ManyToOne
    @JoinColumn(name = "seatid", insertable = false, updatable = false)
    @JsonBackReference(value = "seat-ticket")
    private Seat seat;

    @Column(name = "priceticket")
    private double priceTicket;

    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ticket")
    @JsonManagedReference(value = "ticket-billTicket")
    private Set<BillTicket> billTicketSet;
}
