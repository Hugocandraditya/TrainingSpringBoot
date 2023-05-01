package com.travel.lending.service;

import com.travel.lending.enitity.client.user.Account;
import com.travel.lending.enitity.client.user.AccountResponse;
import com.travel.lending.enitity.client.user.User;
import com.travel.lending.repository.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class UserService {

    @Value(value = "${url.getUserById}")
    private String getUserByIdUrl;
    @Value(value = "${url.getAccountById}")
    private String getAccountByIdUrl;
    @Value(value = "${url.getAccountListByUserId}")
    private String getAccountListByUserIdUrl;
    @Value(value = "${url.verifyUser}")
    private String verifyUserUrl;
    @Autowired
    private UserClientRepository userClientRepository;

    public User getUserById(Long id) {
        try {
            return userClientRepository.getUserById(new URI(getUserByIdUrl),id);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Account getAccountById(Long id) {
        try {
            return userClientRepository.getAccountById(new URI(getAccountByIdUrl),id);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> getAccountListByUserId(Long userId) {
        AccountResponse accountResponse;
        try {
            accountResponse = userClientRepository.getAccountListByUserId(new URI(getAccountListByUserIdUrl),userId);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return accountResponse.getAccountList();
    }

    public boolean verifyUser(Long userId, String pin) {
        try {
            ResponseEntity<Boolean> response = userClientRepository.verifyUser(new URI(verifyUserUrl),userId,pin);
            return response.getBody();
        } catch (Exception e) {
            return false;
        }
    }
}
