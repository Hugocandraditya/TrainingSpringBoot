package com.travel.paymentService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "travel_package")
@Data
public class TravelPackage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Long price;
}