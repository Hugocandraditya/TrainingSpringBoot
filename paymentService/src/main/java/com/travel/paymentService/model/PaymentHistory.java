package com.travel.paymentService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PaymentHistory")
@Data
public class PaymentHistory {
    @Id
    @Column
    private Integer id;
    @Column
    private String userId;
    @Column
    private String accountId;
    @Column
    private String packageId;
    @Column
    private Integer count;
    @Column
    private Integer total;
    @Column
    private Integer status;
}