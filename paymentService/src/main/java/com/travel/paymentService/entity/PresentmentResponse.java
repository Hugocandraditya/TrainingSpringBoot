package com.travel.paymentService.entity;

import lombok.Data;

@Data
public class PresentmentResponse {
    private Integer paymentHistoryId;
    private String name;
    private String account;
    private String packageName;
    private String count;
    private String total;
    private String status;
}