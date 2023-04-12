package com.travel.paymentService.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "travel_package")
@Data
public class TravelPackage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
}