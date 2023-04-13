package com.travel.paymentService.service;

import com.travel.paymentService.entity.ExecuteRequest;
import com.travel.paymentService.entity.client.Account;
import com.travel.paymentService.entity.client.AccountResponse;
import com.travel.paymentService.entity.client.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@Service
public class UserService {

    @Value(value = "${url.useraccount}")
    private String basUrl;

    @Autowired
    private RestTemplate restTemplate;

    public User getUserById(Long id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(basUrl + "/api/user/id")
                .queryParam("id", id);
        return restTemplate.getForObject(builder.toUriString(), User.class);
    }

    public Account getAccountById(Long id) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(basUrl + "/api/account/id")
                .queryParam("id", id);
        return restTemplate.getForObject(builder.toUriString(), Account.class);
    }

    public List<Account> getAccountListByUserId(Long userId) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(basUrl + "/api/account/user_id")
                .queryParam("user_id", userId);
        AccountResponse accountResponse = restTemplate.getForObject(builder.toUriString(), AccountResponse.class);
        return accountResponse.getAccountList();
    }

    public boolean verifyUser(Long userId, String pin) {

        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(basUrl + "/api/account/verify-account")
                    .queryParam("id", userId)
                    .queryParam("pin",pin);
            ResponseEntity<Boolean> response = restTemplate.postForEntity(builder.toUriString(),null,Boolean.class);
            return response.getBody();
        }catch (Exception e){
            return false;
        }
    }
}
