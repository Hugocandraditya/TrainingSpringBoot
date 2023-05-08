package com.travel.useraccount.service;

import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.User;
import com.travel.useraccount.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserRepository deleteById(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Boolean verifyAccount(String pin, Long id) throws Exception {
        Optional<User> dbUser = userRepository.findById(id);
        if (dbUser.isPresent()) {
            // Get Pin from DB
            String dbUserPin = dbUser.get().getPin();
            // Validate input Pin with DB Pin
            if (pin.equals(dbUserPin)) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } else {
            throw new AccountNotFoundException("Account not registered");
        }
    }

}