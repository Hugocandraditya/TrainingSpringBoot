package com.travel.lending.repository;

import com.travel.lending.entity.client.user.Account;
import com.travel.lending.entity.client.user.AccountResponse;
import com.travel.lending.entity.client.user.UpdateAccount;
import com.travel.lending.entity.client.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@FeignClient(value = "user-client", url = "${url.useraccount}")
public interface UserClientRepository {

    @GetMapping
    User getUserById(
            URI url,
            @RequestParam("id") Long id
    );
    @GetMapping
    Account getAccountById(
            URI url,
            @RequestParam("id") Long id
    );
    @GetMapping
    AccountResponse getAccountListByUserId(
            URI url,
            @RequestParam("user_id") Long id
    );
    @PostMapping
    ResponseEntity<Boolean> verifyUser(
            URI url,
            @RequestParam("id") Long id,
            @RequestParam("pin") String pin
    );
    @PostMapping
    void updateAccountBalance(
            URI uri,
            @RequestBody UpdateAccount updateAccount);
}
