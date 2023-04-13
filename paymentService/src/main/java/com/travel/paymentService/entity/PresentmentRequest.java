package com.travel.paymentService.entity;

import lombok.Data;

@Data
public class PresentmentRequest {
    private Long packageId;
    private Long accountId;
    private Long count;
}
