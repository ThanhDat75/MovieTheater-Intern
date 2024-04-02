package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "billticket")
@Getter
@Setter
public class BillTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "billid")
    private int billID;

    @ManyToOne
    @JoinColumn(name = "billid", insertable = false, updatable = false)
    @JsonBackReference(value = "bill-billTicket")
    private Bill bill;

    @Column(name = "ticketid")
    private int ticketID;

    @ManyToOne
    @JoinColumn(name = "ticketid", insertable = false, updatable = false)
    @JsonBackReference(value = "ticket-billTicket")
    private Ticket ticket;
}
