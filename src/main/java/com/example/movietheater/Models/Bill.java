package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "bill")
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "totalmoney")
    private double totalMoney;

    @Column(name = "tradingcode")
    private String tradingCode;

    @Column(name = "createtime")
    private LocalDateTime createTime;

    @Column(name = "customerid")
    private int customerID;

    @ManyToOne
    @JoinColumn(name = "customerid", insertable = false, updatable = false)
    @JsonBackReference(value = "user-bill")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "updatetime")
    private LocalDateTime updateTime;

    @Column(name = "promotionid")
    private int promotionID;

    @ManyToOne
    @JoinColumn(name = "promotionid", insertable = false, updatable = false)
    @JsonBackReference(value = "promotion-bill")
    private Promotion promotion;

    @Column(name = "billstatusid")
    private int billStatusID;

    @ManyToOne
    @JoinColumn(name = "billstatusid", insertable = false, updatable = false)
    @JsonBackReference(value = "billStatus-bill")
    private BillStatus billStatus;

    @Column(name = "isactive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
    @JsonManagedReference(value = "bill-billFood")
    private Set<BillFood> billFoodSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
    @JsonManagedReference(value = "bill-billTicket")
    private Set<BillTicket> billTicketSet;
}
