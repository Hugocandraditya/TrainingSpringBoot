package com.travel.useraccount.controller;

import com.travel.useraccount.model.User;
import com.travel.useraccount.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("id")
    public @ResponseBody Optional<User> getUserById(@RequestParam("id") Long id) {
        return userServiceImpl.findById(id);
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
}
