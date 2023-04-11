package com.travel.paymentService.entity;

import com.travel.paymentService.entity.client.Account;
import com.travel.paymentService.model.Package;
import lombok.Data;

import java.util.List;

@Data
public class PrepareResponse {
    private List<Package> packageList;
    private List<Account> accountList;
}
