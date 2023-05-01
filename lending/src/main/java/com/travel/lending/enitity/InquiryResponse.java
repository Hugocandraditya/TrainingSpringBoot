package com.travel.lending.enitity;

import com.travel.lending.enitity.client.user.Account;
import lombok.Data;

import java.util.List;

@Data
public class InquiryResponse {
    private List<Account> accountList;
}
