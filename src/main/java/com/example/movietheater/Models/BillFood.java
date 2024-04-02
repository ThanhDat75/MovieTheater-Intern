package com.example.movietheater.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "billfood")
@Getter
@Setter
public class BillFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "billid")
    private int billID;

    @ManyToOne
    @JoinColumn(name = "billid", insertable = false, updatable = false)
    @JsonBackReference(value = "bill-billFood")
    private Bill bill;

    @Column(name = "foodid")
    private int foodID;

    @ManyToOne
    @JoinColumn(name = "foodid", insertable = false, updatable = false)
    @JsonBackReference(value = "food-billFood")
    private Food food;


}
