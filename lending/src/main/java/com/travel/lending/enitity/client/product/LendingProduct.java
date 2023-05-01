package com.travel.lending.enitity.client.product;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LendingProduct {
    private Long id;
    private Long userIdLender;
    private Long userIdBorrower;
    private String accountLender;
    private String accountBorrower;
    private BigDecimal interest;
    private BigDecimal amount;
    private BigDecimal totalReimbursement;
    private LocalDateTime dueTime;
    private String reference;
    private String status;
}
