package com.travel.useraccount.controller;

import com.travel.useraccount.model.User;
import com.travel.useraccount.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("user/id")
    public @ResponseBody Optional<User> getUserById(@RequestParam("id") Long id) {
        return userServiceImpl.findById(id);
    }

    @GetMapping("user/all")
    public @ResponseBody List<User> getUserByFirstName() {
        return userServiceImpl.findAll();
    }
}
