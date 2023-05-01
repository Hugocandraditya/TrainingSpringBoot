package com.travel.lending.enitity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExecuteRequest {
    private Long accountId;
    private String pin;
    private BigDecimal interest;
    private BigDecimal amount;
}