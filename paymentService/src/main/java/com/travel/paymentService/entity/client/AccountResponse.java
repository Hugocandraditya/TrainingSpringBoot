package com.travel.paymentService.entity.client;

import lombok.Data;

import java.util.List;

@Data
public class AccountResponse {
    private List<Account> accountList;
}
