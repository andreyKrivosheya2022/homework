package com.example.spring_security.mapping;

import com.example.spring_security.dto.UserDto;
import com.example.spring_security.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreateMapper {

    public User mapFrom(UserDto userDto){
        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }
}
