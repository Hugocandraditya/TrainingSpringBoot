package com.travel.lending.controller;

import com.travel.lending.entity.*;
import com.travel.lending.service.LendingAcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lending-accept")
public class LendingAcceptController {
    @Autowired
    LendingAcceptService lendingAcceptService;

    @GetMapping("/prepare")
    public InquiryAcceptResponse acceptPrepare(
            @RequestParam Long id){
        return lendingAcceptService.prepare(id);
    }


    @PostMapping("/execute")
    public ExecuteLendingAccResponse acceptExecute(
            @RequestParam Long id,
            @RequestBody ExecuteLendingAccRequest request){
        return lendingAcceptService.execute(id, request);
    }

}
