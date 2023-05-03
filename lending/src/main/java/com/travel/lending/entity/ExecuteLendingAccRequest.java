package com.travel.lending.entity;

import lombok.Data;

@Data
public class ExecuteLendingAccRequest {
    private Long productId;
    private Long accountId;
    private String pin;
}
