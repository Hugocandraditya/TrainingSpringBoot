package com.travel.lending.service;

import com.travel.lending.enitity.*;
import com.travel.lending.enitity.client.product.LendingProduct;
import com.travel.lending.enitity.client.user.Account;
import com.travel.lending.enitity.client.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class LendingRequestService {

    @Autowired
    UserService userService;
    @Autowired
    LendingProductService lendingProductService;

    public InquiryRequestResponse prepare(Long userId){
        verifiedUser(userId);
        List<Account> accountList = userService.getAccountListByUserId(userId);
        return mappingPrepareResponse(accountList);
    }

    public ExecuteResponse execute(Long userId, ExecuteRequest request){
        User user = verifiedUser(userId);
        Account account = userService.getAccountById(request.getAccountId());

        ExecuteResponse executeResponse = mappingExecuteResponse(request, user, account);
        saveLendingProduct(executeResponse,user);

        return executeResponse;
    }

    private User verifiedUser(Long userId){
        User user = userService.getUserById(userId);
        if(user == null)
            throw new RuntimeException("Failed verified User");
        return user;
    }

    private InquiryRequestResponse mappingPrepareResponse(List<Account> accountList) {
        InquiryRequestResponse response = new InquiryRequestResponse();
        response.setAccountList(accountList);

        return response;
    }

    private ExecuteResponse mappingExecuteResponse(ExecuteRequest request, User user, Account account) {
        ExecuteResponse executeResponse = new ExecuteResponse();
        executeResponse.setAccountBorrower(account.getAccNumber());
        executeResponse.setEmail(user.getEmail());
        executeResponse.setInterest(request.getInterest());
        executeResponse.setAmount(request.getAmount());
        executeResponse.setTotalReimbursement(countTotalReimburse(request.getAmount(), request.getInterest()));
        executeResponse.setReference(UUID.randomUUID().toString());
        executeResponse.setStatus("REQUESTED");

        return executeResponse;
    }

    private void saveLendingProduct(ExecuteResponse response, User user){
        LendingProduct lendingProduct = new LendingProduct();
        lendingProduct.setUserIdBorrower(user.getId());
        lendingProduct.setAccountBorrower(response.getAccountBorrower());
        lendingProduct.setInterest(response.getInterest());
        lendingProduct.setAmount(response.getAmount());
        lendingProduct.setTotalReimbursement(response.getTotalReimbursement());
        lendingProduct.setReference(response.getReference());
        lendingProduct.setStatus(response.getStatus());

        lendingProductService.createLendingProduct(lendingProduct);
    }
    private BigDecimal countTotalReimburse(BigDecimal amount, BigDecimal interest){
        return amount.multiply(interest);
    }

}
