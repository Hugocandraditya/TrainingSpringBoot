package com.travel.paymentService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "travel_history")
@Data
public class PaymentHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "package_name")
    private String packageName;
    @Column(name = "count")
    private Long count;
    @Column(name = "total")
    private Long total;
    @Column(name = "status")
    private String status;
}