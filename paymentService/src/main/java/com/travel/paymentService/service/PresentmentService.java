package com.travel.paymentService.service;

import com.travel.paymentService.entity.PrepareResponse;
import com.travel.paymentService.entity.PresentmentRequest;
import com.travel.paymentService.entity.PresentmentResponse;
import com.travel.paymentService.model.PaymentHistory;
import com.travel.paymentService.model.TravelPackage;
import com.travel.paymentService.repository.PaymentHistoryDBRepository;
import com.travel.paymentService.repository.TravelPackageDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresentmentService {
    @Autowired
    PaymentHistoryDBRepository paymentHistoryRepo;

    @Autowired
    TravelPackageDBRepository travelPackageRepo;

    public PresentmentResponse presentment(PresentmentRequest request){
//        TODO: inquiry user
//        TODO: verif id
//        TODO: inquiry package by id
        Optional<TravelPackage> travelPackageOpt = travelPackageRepo.findById(request.getPackageId());
        TravelPackage travelPackage = travelPackageOpt.get();
//        TODO: inquiry account by id
//        TODO: add payment history

        PaymentHistory paymentHistory = savePaymentHistory(request, travelPackage);
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

    private PaymentHistory savePaymentHistory(PresentmentRequest request, TravelPackage travelPackage) {
        Integer total = request.getCount()*travelPackage.getPrice();
        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setName(null);
        paymentHistory.setEmail(null);
        paymentHistory.setAccountNumber(null);
        paymentHistory.setPackageName(travelPackage.getName());
        paymentHistory.setCount(request.getCount());
        paymentHistory.setTotal(total);
        paymentHistory.setStatus("PENDING");

        return paymentHistory;
    }
}
