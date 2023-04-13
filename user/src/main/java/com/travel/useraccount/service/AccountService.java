package com.travel.useraccount.service;

import com.travel.useraccount.model.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findById(Long id);

    Optional<Account> findByUserId(Long user_id);
}