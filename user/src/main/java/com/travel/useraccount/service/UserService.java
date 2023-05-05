package com.travel.useraccount.service;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.User;
import com.travel.useraccount.repository.AccountRepository;
import com.travel.useraccount.repository.UserRepository;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);

    UserRepository deleteById(Long id);

    User save(User user);
}