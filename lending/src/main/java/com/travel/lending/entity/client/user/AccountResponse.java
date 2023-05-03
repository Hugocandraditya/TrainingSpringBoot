package com.travel.lending.entity.client.user;

import lombok.Data;

import java.util.List;

@Data
public class AccountResponse {
    private List<Account> accountList;
}
