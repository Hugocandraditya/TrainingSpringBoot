package com.travel.useraccount.controller;

import com.travel.useraccount.dto.UserDto;
import com.travel.useraccount.model.User;
import com.travel.useraccount.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;

import static com.travel.useraccount.dto.UserDto.convertToDto;

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

//    @GetMapping(value = "/{id}")
//    @ResponseBody
//    public PostDto getPost(@PathVariable("id") Long id) {
//        return convertToDto(postService.getPostById(id));
//    }

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
