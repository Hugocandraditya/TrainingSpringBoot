package com.travel.lending.enitity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExecuteLendingAccRequest {
    private Long productId;
    private Long accountId;
    private String pin;
}
