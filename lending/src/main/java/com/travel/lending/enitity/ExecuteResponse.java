package com.travel.lending.enitity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExecuteResponse {
    private String accountBorrower;
    private String email;
    private BigDecimal interest;
    private BigDecimal amount;
    private BigDecimal totalReimbursement;
    private String dueTime;
    private String reference;
    private String status;
}