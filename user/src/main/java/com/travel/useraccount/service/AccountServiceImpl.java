package com.travel.useraccount.service;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.AccountList;
import com.travel.useraccount.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public AccountList findByUserId(Long userId) {

         List<Account> accountList = accountRepository.findByUserId(userId);
         AccountList accountList1 = new AccountList();
         accountList1.setAccountList(accountList);
         return  accountList1;
    }
}