package com.travel.paymentService.entity;

import lombok.Data;

@Data
public class ExecuteRequest {
    private Integer paymentHistoryId;
    private String password;
}
