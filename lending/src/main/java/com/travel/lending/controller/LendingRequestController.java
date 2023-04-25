package com.travel.lending.controller;

import com.travel.lending.enitity.*;
import com.travel.lending.service.LendingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lending-request")
public class LendingRequestController {
    @Autowired
    LendingRequestService lendingProductService;

    @GetMapping("/prepare")
    public PrepareResponse AcceptPrepare(){
        return lendingProductService.prepare();
    }

    @PostMapping("/presentment")
    public PresentmentResponse AcceptPresentment(
            @RequestBody PresentmentRequest request){
        return lendingProductService.presentment(request);
    }

    @PostMapping("/execute")
    public ExecuteResponse AcceptExecute(
            @RequestBody ExecuteRequest request){
        return lendingProductService.execute(request);
    }
}
