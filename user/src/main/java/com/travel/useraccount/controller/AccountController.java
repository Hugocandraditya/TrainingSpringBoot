package com.travel.useraccount.controller;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class AccountController {
    @Autowired
    AccountServiceImpl accountServiceImpl;

    @GetMapping("account/id")
    public @ResponseBody Optional<Account> getAccountById(@RequestParam("id") Long id) {
        return accountServiceImpl.findById(id);
    }

    @GetMapping("account/user_id")
    public @ResponseBody Optional<Account> getAccountByUserId(@RequestParam("user_id") Long userId) {
        return accountServiceImpl.findByUserId(userId);
    }
}
