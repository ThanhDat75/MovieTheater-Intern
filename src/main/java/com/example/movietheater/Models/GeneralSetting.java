package com.example.movietheater.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "generalsetting")
@Getter
@Setter
public class GeneralSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "breaktime")
    private LocalDateTime breakTime;

    @Column(name = "businesshours")
    private int businesshours;

    @Column(name = "closetime")
    private LocalDateTime closeTime;

    @Column(name = "fixedticketprice")
    private double fixedTicketPrice;

    @Column(name = "percentday")
    private int percentDay;

    @Column(name = "percentweekend")
    private int percentWeekend;

    @Column(name = "timebegintochage")
    private LocalDateTime timeBeginToChange;
}
