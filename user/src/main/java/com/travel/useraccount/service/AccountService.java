package com.travel.useraccount.service;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.AccountList;
import com.travel.useraccount.repository.AccountRepository;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findById(Long id);

    AccountList findByUserId(Long user_id);

    AccountRepository deleteById(Long id);

    Account save(Account account);
}