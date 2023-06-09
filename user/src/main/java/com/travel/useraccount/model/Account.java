package com.travel.useraccount.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "acc_number")
    private String acc_number;
    @Column(name = "acc_type")
    private String acc_type;
    @Column(name = "acc_name")
    private String acc_name;
    @Column(name = "balance")
    private BigDecimal balance;
    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAcc_number() {
        return acc_number;
    }

    public void setAcc_number(String acc_number) {
        this.acc_number = acc_number;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account(Long id, Long userId, String acc_number, String acc_type, String acc_name, BigDecimal balance) {
        this.id = id;
        this.userId = userId;
        this.acc_number = acc_number;
        this.acc_type = acc_type;
        this.acc_name = acc_name;
        this.balance = balance;
    }



}