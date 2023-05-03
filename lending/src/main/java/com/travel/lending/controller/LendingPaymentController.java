package com.travel.lending.controller;

import com.travel.lending.entity.*;
import com.travel.lending.service.LendingPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lending-payment")
public class LendingPaymentController {
    @Autowired
    LendingPaymentService lendingProductService;

    @GetMapping("/prepare")
    public InquiryResponse paymentPrepare(
            @RequestParam Long id){
        return lendingProductService.prepare(id);
    }

    @PostMapping("/execute")
    public ExecuteLendingReqResponse paymentExecute(
            @RequestBody ExecuteLendingReqRequest request){
        return lendingProductService.execute(request);
    }
}
