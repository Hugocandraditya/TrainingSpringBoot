package com.travel.lending.controller;

import com.travel.lending.enitity.*;
import com.travel.lending.service.LendingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lending-request")
public class LendingRequestController {
    @Autowired
    LendingRequestService lendingProductService;

    @GetMapping("/prepare")
    public InquiryRequestResponse AcceptPrepare(
            @RequestParam Long id){
        return lendingProductService.prepare(id);
    }

    @PostMapping("/execute")
    public ExecuteResponse AcceptExecute(
            @RequestParam Long id,
            @RequestBody ExecuteRequest request){
        return lendingProductService.execute(id, request);
    }
}
