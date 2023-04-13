package com.travel.paymentService.service;

import com.travel.paymentService.entity.PrepareResponse;
import com.travel.paymentService.entity.client.Account;
import com.travel.paymentService.entity.client.User;
import com.travel.paymentService.model.PaymentHistory;
import com.travel.paymentService.model.TravelPackage;
import com.travel.paymentService.repository.PaymentHistoryDBRepository;
import com.travel.paymentService.repository.TravelPackageDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PrepareService {
    @Autowired
    TravelPackageDBRepository travelPackageRepo;


    @Autowired
    UserService userService;

    public PrepareResponse prepare(Long userId){
//        TODO: inquiry user
        User user = userService.getUserById(userId);
//        TODO: verif id
        if(user == null)
            throw new RuntimeException("Failed prepare");
//        TODO: inquiry all package
        List<TravelPackage> travelPackageList = travelPackageRepo.findAll();
//        TODO: inquiry list Account by id
        List<Account> accountList = userService.getAccountListByUserId(userId);
//        TODO: mapping response
        return mappingPrepareResponse(accountList, travelPackageList);
    }

    private PrepareResponse mappingPrepareResponse(List<Account> accountList, List<TravelPackage> travelPackageList) {
        PrepareResponse response = new PrepareResponse();
        response.setPackageList(travelPackageList);
        response.setAccountList(accountList);

        return response;
    }

}
