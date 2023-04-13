package com.travel.useraccount.service;

import com.travel.useraccount.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
}