package com.travel.lending.controller;

import com.travel.lending.enitity.*;
import com.travel.lending.service.LendingAcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lending-accept")
public class LendingAcceptController {
    @Autowired
    LendingAcceptService lendingAcceptService;

    @GetMapping("/prepare")
    public PrepareResponse AcceptPrepare(){
        return lendingAcceptService.prepare();
    }

    @PostMapping("/presentment")
    public PresentmentResponse AcceptPresentment(
            @RequestBody PresentmentRequest request){
        return lendingAcceptService.presentment(request);
    }

    @PostMapping("/execute")
    public ExecuteResponse AcceptExecute(
            @RequestBody ExecuteRequest request){
        return lendingAcceptService.execute(request);
    }

}
