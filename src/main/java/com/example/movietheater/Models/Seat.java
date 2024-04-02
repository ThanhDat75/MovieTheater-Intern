package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "seat")
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "seatstatusid")
    private int seatStatusID;

    @ManyToOne
    @JoinColumn(name = "seatstatusid", insertable = false, updatable = false)
    @JsonBackReference(value = "seatStatus-seat")
    private SeatStatus seatStatus;

    @Column(name = "line")
    private String line;

    @Column(name = "roomid")
    private int roomID;

    @ManyToOne
    @JoinColumn(name = "roomid", insertable = false, updatable = false)
    @JsonBackReference(value = "room-seat")
    private Room room;

    @Column(name = "isactive")
    private boolean isActive;

    @Column(name = "seattypeid")
    private int seatTypeID;

    @ManyToOne
    @JoinColumn(name = "seattypeid", insertable = false, updatable = false)
    @JsonBackReference(value = "seatType-seat")
    private SeatType seatType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seat")
    @JsonManagedReference(value = "seat-ticket")
    private Set<Ticket> ticketSet;
}
