package com.travel.useraccount.service;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.AccountList;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findById(Long id);

    AccountList findByUserId(Long user_id);
}