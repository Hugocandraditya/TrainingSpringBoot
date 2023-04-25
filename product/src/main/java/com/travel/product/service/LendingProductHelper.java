package com.travel.product.service;

import com.travel.product.enitity.LendingProduct;
import com.travel.product.model.LendingProductModel;
import com.travel.product.repository.LendingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public class LendingProductHelper {

    public static LendingProduct mapLendingProduct(LendingProductModel lendingProductModel){
        LendingProduct lendingProduct = new LendingProduct();
        lendingProduct.setId(lendingProductModel.getId());
        lendingProduct.setUserIdLender(lendingProductModel.getUserIdLender());
        lendingProduct.setUserIdBorrower(lendingProductModel.getUserIdBorrower());
        lendingProduct.setAccountLender(lendingProductModel.getAccountLender());
        lendingProduct.setAccountBorrower(lendingProductModel.getAccountBorrower());
        lendingProduct.setInterest(lendingProductModel.getInterest());
        lendingProduct.setAmount(lendingProductModel.getAmount());
        lendingProduct.setTotalReimbursement(lendingProductModel.getTotalReimbursement());
        lendingProduct.setDueTime(lendingProductModel.getDueTime());
        lendingProduct.setReference(lendingProductModel.getReference());
        lendingProduct.setStatus(lendingProductModel.getStatus());

        return lendingProduct;
    }

    public static LendingProductModel mapLendingProductModel(LendingProduct lendingProduct){
        LendingProductModel lendingProductModel = new LendingProductModel();
        lendingProductModel.setId(lendingProduct.getId());
        lendingProductModel.setUserIdLender(lendingProduct.getUserIdLender());
        lendingProductModel.setUserIdBorrower(lendingProduct.getUserIdBorrower());
        lendingProductModel.setAccountLender(lendingProduct.getAccountLender());
        lendingProductModel.setAccountBorrower(lendingProduct.getAccountBorrower());
        lendingProductModel.setInterest(lendingProduct.getInterest());
        lendingProductModel.setAmount(lendingProduct.getAmount());
        lendingProductModel.setTotalReimbursement(lendingProduct.getTotalReimbursement());
        lendingProductModel.setDueTime(lendingProduct.getDueTime());
        lendingProductModel.setReference(lendingProduct.getReference());
        lendingProductModel.setStatus(lendingProduct.getStatus());

        return lendingProductModel;
    }
}