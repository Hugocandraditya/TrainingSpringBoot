package com.travel.lending.entity;

import com.travel.lending.entity.client.user.Account;
import lombok.Data;

import java.util.List;

@Data
public class InquiryResponse {
    private List<Account> accountList;
}
