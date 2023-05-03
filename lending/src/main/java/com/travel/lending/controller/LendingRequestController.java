package com.travel.lending.controller;

import com.travel.lending.entity.*;
import com.travel.lending.service.LendingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lending-request")
public class LendingRequestController {
    @Autowired
    LendingRequestService lendingProductService;

    @GetMapping("/prepare")
    public InquiryRequestResponse requestPrepare(
            @RequestParam Long id){
        return lendingProductService.prepare(id);
    }

    @PostMapping("/execute")
    public ExecuteLendingReqResponse requestExecute(
            @RequestParam Long id,
            @RequestBody ExecuteLendingReqRequest request){
        return lendingProductService.execute(id, request);
    }
}
