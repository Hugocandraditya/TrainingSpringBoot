package com.travel.paymentService.controller;

import com.travel.paymentService.entity.*;
import com.travel.paymentService.service.ExecuteService;
import com.travel.paymentService.service.PrepareService;
import com.travel.paymentService.service.PresentmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/travel")
public class PaymentController {

    @Autowired
    PrepareService prepareService;
    @Autowired
    PresentmentService presentmentService;
    @Autowired
    ExecuteService executeService;

    @GetMapping("/prepare")
    public @ResponseBody
    PrepareResponse prepare(
            @RequestParam String id){
        return prepareService.prepare(id);
    }

    @PostMapping("/presentment")
    public PresentmentResponse presentment(
            @RequestParam String id,
            @RequestBody PresentmentRequest request){
        return presentmentService.presentment(request);
    }


    @PostMapping("/execute")
    public ExecuteResponse execute(
            @RequestParam String id,
            @RequestBody ExecuteRequest request){
        return executeService.execute(request);
    }
}
