package com.travel.lending.service;

import com.travel.lending.entity.*;
import com.travel.lending.entity.client.product.LendingProduct;
import com.travel.lending.entity.client.user.Account;
import com.travel.lending.entity.client.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LendingAcceptService {

    @Autowired
    UserService userService;
    @Autowired
    LendingProductService lendingProductService;

    public InquiryAcceptResponse prepare(Long userId){
        verifiedUser(userId);
        List<Account> accountList = userService.getAccountListByUserId(userId);
        List<LendingProduct> lendingProductList = lendingProductService.getLendingProductList();
        lendingProductList = lendingProductList.stream()
                .filter(lendingProduct -> LendingHelper.REQ_STATUS.equals(lendingProduct.getStatus()) && !Objects.equals(userId, lendingProduct.getUserIdBorrower()))
                .collect(Collectors.toList());
        return mappingPrepareResponse(accountList, lendingProductList);
    }


    public ExecuteLendingAccResponse execute(Long userId, ExecuteLendingAccRequest request){

        User user = verifiedUser(userId);
        verifiedPin(userId, request.getPin());
        Account account = userService.getAccountById(request.getAccountId());

        LendingProduct lendingProduct = lendingProductService.getLendingProductById(request.getProductId());

        userService.updateAccountBalance(
                lendingProduct.getUserIdBorrower(),
                userId,
                lendingProduct.getAccountBorrower(),
                account.getAccNumber(),
                lendingProduct.getAmount()
        );

        ExecuteLendingAccResponse executeLendingAccResponse = mappingExecuteResponse(lendingProduct, user, account);
        saveLendingProduct(lendingProduct, executeLendingAccResponse, user);

        return executeLendingAccResponse;
    }

    private InquiryAcceptResponse mappingPrepareResponse(List<Account> accountList, List<LendingProduct> lendingProductList) {
        InquiryAcceptResponse inquiryAcceptResponse = new InquiryAcceptResponse();
        inquiryAcceptResponse.setAccountList(accountList);
        inquiryAcceptResponse.setLendingProductList(lendingProductList);
        return inquiryAcceptResponse;
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

    private ExecuteLendingAccResponse mappingExecuteResponse(LendingProduct lendingProduct, User user, Account account) {
        ExecuteLendingAccResponse response = new ExecuteLendingAccResponse();
        response.setAccountLender(account.getAccNumber());
        response.setEmail(user.getEmail());
        response.setInterest(lendingProduct.getInterest());
        response.setAmount(lendingProduct.getAmount());
        response.setTotalReimbursement(lendingProduct.getTotalReimbursement());
        response.setReference(lendingProduct.getReference());
        response.setStatus(LendingHelper.ACC_STATUS);

        return response;
    }

    private void saveLendingProduct(LendingProduct lendingProduct, ExecuteLendingAccResponse response, User user) {
        lendingProduct.setUserIdLender(user.getId());
        lendingProduct.setAccountLender(response.getAccountLender());
        lendingProduct.setDueTime(LocalDateTime.now().plusMonths(1));
        lendingProduct.setStatus(response.getStatus());

        lendingProductService.updateLendingProduct(lendingProduct);
    }
}