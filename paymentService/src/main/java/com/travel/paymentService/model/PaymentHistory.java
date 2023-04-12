package com.travel.paymentService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payment_history")
@Data
public class PaymentHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "package_name")
    private String packageName;
    @Column(name = "count")
    private Integer count;
    @Column(name = "total")
    private Integer total;
    @Column(name = "status")
    private String status;
}