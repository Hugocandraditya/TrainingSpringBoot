package com.travel.lending.enitity;

import lombok.Data;

@Data
public class ExecuteResponse {
    private String name;
    private String account;
    private String packageName;
    private String count;
    private String total;
    private String status;
}