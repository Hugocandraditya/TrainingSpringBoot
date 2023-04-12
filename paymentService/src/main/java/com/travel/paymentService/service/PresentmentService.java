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

        PaymentHistory paymentHistory = savePaymentHistory(travelPackage);
//        TODO: mapping response
        return new PresentmentResponse();
    }

    private PaymentHistory savePaymentHistory(TravelPackage travelPackage) {
        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setId();
        paymentHistory.setName();
        paymentHistory.setEmail();
        paymentHistory.setAccountNumber();
        paymentHistory.setPackageName();
        paymentHistory.setCount();
        paymentHistory.setTotal();
        paymentHistory.setStatus();
    }

    private PrepareResponse mappingPrepareResponse(List<TravelPackage> travelPackageList) {

        PrepareResponse response = new PrepareResponse();
        response.setPackageList(travelPackageList);

        return response;
    }
}
