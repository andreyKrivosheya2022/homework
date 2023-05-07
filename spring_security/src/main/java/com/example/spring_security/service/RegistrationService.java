package com.example.spring_security.service;

import com.example.spring_security.dto.UserDto;
import com.example.spring_security.mapping.UserCreateMapper;
import com.example.spring_security.model.Role;
import com.example.spring_security.model.User;
import com.example.spring_security.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationService {
    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder encoder;

    private final UserCreateMapper userCreateMapper;

    @Autowired
    public RegistrationService(UserDetailsRepository userDetailsRepository, PasswordEncoder encoder, UserCreateMapper userCreateMapper) {
        this.userDetailsRepository = userDetailsRepository;
        this.encoder = encoder;
        this.userCreateMapper = userCreateMapper;
    }

    public void registration(UserDto userDto) {
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        User userEntity = userCreateMapper.mapFrom(userDto);
        userEntity.setRole(Role.ROLE_USER);
        userDetailsRepository.save(userEntity);
    }
}
