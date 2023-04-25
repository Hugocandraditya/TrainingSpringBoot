package com.travel.lending.enitity;

import lombok.Data;

@Data
public class PresentmentRequest {
    private Long packageId;
    private Long accountId;
    private Long count;
}
