package com.travel.lending.enitity.client.product;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LendingProduct {
    private Long id;
    private Long userIdLender;
    private Long userIdBorrower;
    private String accountLender;
    private String accountBorrower;
    private Long interest;
    private Long amount;
    private Long totalReimbursement;
    private LocalDateTime dueTime;
    private String reference;
    private String status;
}
