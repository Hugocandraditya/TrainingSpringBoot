package com.travel.useraccount.controller;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.AccountList;
import com.travel.useraccount.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountServiceImpl accountServiceImpl;

    @GetMapping("id")
    public @ResponseBody Optional<Account> getAccountById(@RequestParam("id") Long id) {
        return accountServiceImpl.findById(id);
    }

    @GetMapping("user_id")
    public @ResponseBody AccountList getAccountByUserId(@RequestParam("user_id") Long userId) {
        return accountServiceImpl.findByUserId(userId);
    }


}
