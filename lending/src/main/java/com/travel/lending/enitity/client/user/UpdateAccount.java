package com.travel.lending.enitity.client.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateAccount {
    private Long userIdBorrower;
    private Long userIdLender;
    private String accountBorrower;
    private String accountLender;
    private BigDecimal amount;
}
