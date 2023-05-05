package com.travel.useraccount.dto;

import com.travel.useraccount.model.User;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class UserDto {

    private Long id;
    private String name;
    private String email;
//    private UserDto dto;
//    private List<UserDto> listDto;

    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public static UserDto convertToDto(Optional<User> user) {
        return modelMapper().map(user, UserDto.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
