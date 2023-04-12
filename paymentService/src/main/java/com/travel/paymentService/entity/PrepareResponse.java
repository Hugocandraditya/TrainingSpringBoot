package com.travel.paymentService.entity;

import com.travel.paymentService.entity.client.Account;
import com.travel.paymentService.model.TravelPackage;
import lombok.Data;

import java.util.List;

@Data
public class PrepareResponse {
    private List<TravelPackage> packageList;
    private List<Account> accountList;
}
