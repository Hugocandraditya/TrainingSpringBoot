package com.travel.paymentService.service;

import com.travel.paymentService.entity.PrepareResponse;
import com.travel.paymentService.model.PaymentHistory;
import com.travel.paymentService.model.TravelPackage;
import com.travel.paymentService.repository.PaymentHistoryDBRepository;
import com.travel.paymentService.repository.TravelPackageDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PrepareService {
    @Autowired
    TravelPackageDBRepository travelPackageRepo;

    public PrepareResponse prepare(String id){
//        TODO: inquiry user
//        TODO: verif id
//        TODO: inquiry all package
        List<TravelPackage> travelPackageList = travelPackageRepo.findAll();
//        TODO: inquiry list Account by id
//        TODO: mapping response
        return mappingPrepareResponse(travelPackageList);
    }

    private PrepareResponse mappingPrepareResponse(List<TravelPackage> travelPackageList) {
        PrepareResponse response = new PrepareResponse();
        response.setPackageList(travelPackageList);

        return response;
    }

}
