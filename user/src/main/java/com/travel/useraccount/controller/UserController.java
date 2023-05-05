package com.travel.useraccount.controller;

import com.travel.useraccount.dto.UserDto;
import com.travel.useraccount.model.Account;
import com.travel.useraccount.model.User;
import com.travel.useraccount.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("id")
    public @ResponseBody UserDto getUserById(@RequestParam("id") Long id) {
        return UserDto.convertToDto(userServiceImpl.findById(id));
    }

    @GetMapping("all")
    public @ResponseBody List<User> getUserByFirstName() {
        return userServiceImpl.findAll();
    }

    @PostMapping("verify-account")
    public @ResponseBody Boolean verifyPin(@RequestParam("pin") String pin,
                                           @RequestParam("id") Long id) throws Exception {
        Boolean result = userServiceImpl.verifyAccount(pin, id);
        if (result.equals(Boolean.TRUE)) {
            return Boolean.TRUE;
        } else {
            throw new LoginException("Invalid PIN");
        }

    }

    @PostMapping("/create")
    public User createAccount(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("pin") String pin,
            @RequestParam("role") String role
    ) {
        return userServiceImpl.save(new User(
                id,
                name,
                email,
                pin,
                role
        ));
    }

    @DeleteMapping("delete")
    public ResponseEntity<HttpStatus> deleteAccount(@RequestParam("id") Long id) {
        try {
            userServiceImpl.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
