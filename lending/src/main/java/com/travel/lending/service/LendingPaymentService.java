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

    public PrepareResponse prepare(){
        return null;
    }

    public PresentmentResponse presentment(PresentmentRequest request){
        return null;
    }

    public ExecuteResponse execute(ExecuteRequest request){
        return null;
    }
}
