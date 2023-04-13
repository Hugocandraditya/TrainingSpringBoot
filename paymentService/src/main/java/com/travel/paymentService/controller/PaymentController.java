package com.travel.paymentService.controller;

import com.travel.paymentService.entity.*;
import com.travel.paymentService.service.ExecuteService;
import com.travel.paymentService.service.PrepareService;
import com.travel.paymentService.service.PresentmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travel")
public class PaymentController {

    @Autowired
    PrepareService prepareService;
    @Autowired
    PresentmentService presentmentService;
    @Autowired
    ExecuteService executeService;

    @GetMapping("/prepare")
    public PrepareResponse prepare(
            @RequestParam Long id){
        return prepareService.prepare(id);
    }

    @PostMapping("/presentment")
    public PresentmentResponse presentment(
            @RequestParam Long id,
            @RequestBody PresentmentRequest request){
        return presentmentService.presentment(id, request);
    }


    @PostMapping("/execute")
    public ExecuteResponse execute(
            @RequestParam Long id,
            @RequestBody ExecuteRequest request){
        return executeService.execute(id, request);
    }
}
