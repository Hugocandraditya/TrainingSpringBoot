package com.travel.lending.enitity;

import lombok.Data;

@Data
public class ExecuteRequest {
    private Long paymentHistoryId;
    private String pin;
}
