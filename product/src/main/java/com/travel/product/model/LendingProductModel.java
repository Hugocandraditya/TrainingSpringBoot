package com.travel.product.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "lending_product")
@Data
public class LendingProductModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id_lender")
    private Long userIdLender;
    @Column(name = "user_id_borrower")
    private Long userIdBorrower;
    @Column(name = "account_lender")
    private String accountLender;
    @Column(name = "account_borrower")
    private String accountBorrower;
    @Column(name = "interest")
    private Long interest;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "total_reimbursement")
    private Long totalReimbursement;
    @Column(name = "due_time")
    private LocalDateTime dueTime;
    @Column(name = "reference")
    private String reference;
    @Column(name = "status")
    private String status;
}











