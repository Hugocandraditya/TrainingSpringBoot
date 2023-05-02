package com.travel.lending.service;

import com.travel.lending.enitity.*;
import com.travel.lending.repository.LendingProductRepository;
import com.travel.lending.repository.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LendingPaymentService {

    @Autowired
    LendingProductRepository lendingProductRepository;
    @Autowired
    UserClientRepository userClientRepository;

    public InquiryResponse prepare(Long userId){
        return null;
    }


    public ExecuteLendingReqResponse execute(ExecuteLendingReqRequest request){
        return null;
    }
}
