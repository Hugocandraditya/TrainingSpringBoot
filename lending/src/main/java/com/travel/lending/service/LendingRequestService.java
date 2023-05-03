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

    public ExecuteLendingReqResponse execute(Long userId, ExecuteLendingReqRequest request){
        User user = verifiedUser(userId);
        verifiedPin(userId, request.getPin());
        Account account = userService.getAccountById(request.getAccountId());

        ExecuteLendingReqResponse executeLendingReqResponse = mappingExecuteResponse(request, user, account);
        saveLendingProduct(executeLendingReqResponse,user);

        return executeLendingReqResponse;
    }

    private User verifiedUser(Long userId){
        User user = userService.getUserById(userId);
        if(user == null)
            throw new RuntimeException("Failed verified User");
        return user;
    }

    private void verifiedPin(Long userId, String pin){
        if(!userService.verifyUser(userId,pin))
            throw new RuntimeException("Verification Failed");
    }

    private InquiryRequestResponse mappingPrepareResponse(List<Account> accountList) {
        InquiryRequestResponse response = new InquiryRequestResponse();
        response.setAccountList(accountList);

        return response;
    }

    private ExecuteLendingReqResponse mappingExecuteResponse(ExecuteLendingReqRequest request, User user, Account account) {
        ExecuteLendingReqResponse executeLendingReqResponse = new ExecuteLendingReqResponse();
        executeLendingReqResponse.setAccountBorrower(account.getAccNumber());
        executeLendingReqResponse.setEmail(user.getEmail());
        executeLendingReqResponse.setInterest(request.getInterest());
        executeLendingReqResponse.setAmount(request.getAmount());
        executeLendingReqResponse.setTotalReimbursement(countTotalReimburse(request.getAmount(), request.getInterest()));
        executeLendingReqResponse.setReference(UUID.randomUUID().toString());
        executeLendingReqResponse.setStatus(LendingHelper.REQ_STATUS);

        return executeLendingReqResponse;
    }

    private void saveLendingProduct(ExecuteLendingReqResponse response, User user){
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
        return amount.add(amount.multiply(interest).divide(new BigDecimal(100)));
    }

}
