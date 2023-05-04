package com.travel.useraccount.controller;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.AccountList;
import com.travel.useraccount.repository.AccountRepository;
import com.travel.useraccount.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create")
    public Account createAccount(
            @RequestParam("id") Long id,
            @RequestParam("userId") Long userId,
            @RequestParam("accNumber") String accNumber,
            @RequestParam("accType") String accType,
            @RequestParam("accName") String accName,
            @RequestParam("balance") Long balance
    ) {
        return accountServiceImpl.save(new Account(
                id,
                userId,
                accNumber,
                accType,
                accName,
                balance
        ));
    }

    @DeleteMapping("delete")
    public ResponseEntity<HttpStatus> deleteAccount(@RequestParam("id") Long id) {
        try {
            accountServiceImpl.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("update-balance")
    public void updateBalanceAccount(
            @RequestParam("amount") Long amount,
            @RequestParam("borrowerId") Long borrowerId,
            @RequestParam("lenderId") Long lenderId) {
        try {
            accountServiceImpl.updateBalance(amount, getAccountById(borrowerId), getAccountById(lenderId));
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

}
