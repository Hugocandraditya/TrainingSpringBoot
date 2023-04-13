package com.travel.paymentService.entity;

import lombok.Data;

@Data
public class ExecuteRequest {
    private Long paymentHistoryId;
    private String pin;
}
