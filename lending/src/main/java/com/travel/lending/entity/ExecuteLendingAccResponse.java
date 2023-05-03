package com.travel.lending.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExecuteLendingAccResponse {
    private String accountLender;
    private String email;
    private BigDecimal interest;
    private BigDecimal amount;
    private BigDecimal totalReimbursement;
    private LocalDateTime dueTime;
    private String reference;
    private String status;
}