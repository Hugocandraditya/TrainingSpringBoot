package com.travel.paymentService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Package")
@Data
public class Package {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String price;
}