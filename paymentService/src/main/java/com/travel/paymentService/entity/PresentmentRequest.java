package com.travel.paymentService.entity;

import lombok.Data;

@Data
public class PresentmentRequest {
    private Integer packageId;
    private Integer accountId;
    private Integer count;
}
