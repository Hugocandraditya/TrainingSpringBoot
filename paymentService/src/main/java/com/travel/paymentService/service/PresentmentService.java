package com.travel.paymentService.service;

import com.travel.paymentService.entity.PresentmentRequest;
import com.travel.paymentService.entity.PresentmentResponse;
import com.travel.paymentService.entity.client.Account;
import com.travel.paymentService.entity.client.User;
import com.travel.paymentService.model.PaymentHistory;
import com.travel.paymentService.model.TravelPackage;
import com.travel.paymentService.repository.PaymentHistoryDBRepository;
import com.travel.paymentService.repository.TravelPackageDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PresentmentService {
    @Autowired
    PaymentHistoryDBRepository paymentHistoryRepo;

    @Autowired
    TravelPackageDBRepository travelPackageRepo;

    @Autowired
    UserService userService;

    public PresentmentResponse presentment(Long userId, PresentmentRequest request){
//        TODO: inquiry user
        User user = userService.getUserById(userId);
//        TODO: verif id
        if(user == null)
            throw new RuntimeException("Failed presentment");
//        TODO: inquiry package by id
        Optional<TravelPackage> travelPackageOpt = travelPackageRepo.findById(request.getPackageId());
        TravelPackage travelPackage = travelPackageOpt.get();
//        TODO: inquiry account by id
        Account account = userService.getAccountById(request.getAccountId());
//        TODO: add payment history
        PaymentHistory paymentHistory = savePaymentHistory(request, user, account, travelPackage);
//        TODO: mapping response
        return mappingPresentmentResponse(paymentHistory);
    }

    private PresentmentResponse mappingPresentmentResponse(PaymentHistory paymentHistory) {
        PresentmentResponse response = new PresentmentResponse();
        response.setPaymentHistoryId(paymentHistory.getId());
        response.setName(paymentHistory.getName());
        response.setAccount(paymentHistory.getAccountNumber());
        response.setPackageName(paymentHistory.getPackageName());
        response.setCount(paymentHistory.getCount().toString());
        response.setTotal(paymentHistory.getTotal().toString());
        response.setStatus(paymentHistory.getStatus());
        return response;
    }

    private PaymentHistory savePaymentHistory(PresentmentRequest request, User user, Account account, TravelPackage travelPackage) {
        Long total = request.getCount()*travelPackage.getPrice();
        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setName(user.getName());
        paymentHistory.setEmail(user.getEmail());
        paymentHistory.setAccountNumber(account.getAccNumber());
        paymentHistory.setPackageName(travelPackage.getName());
        paymentHistory.setCount(request.getCount());
        paymentHistory.setTotal(total);
        paymentHistory.setStatus("PENDING");

        paymentHistory = paymentHistoryRepo.save(paymentHistory);

        return paymentHistory;
    }

}
