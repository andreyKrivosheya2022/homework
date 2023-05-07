package com.example.spring_security.service;

import com.example.spring_security.model.User;
import com.example.spring_security.repository.UserDetailsRepository;
import com.example.spring_security.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

    private final UserDetailsRepository userRepository;

    @Autowired
    public UserService(UserDetailsRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userEntity = userRepository.findByUsername(username);
        if(userEntity.isEmpty()){
            throw new UsernameNotFoundException("invalid username");
        }
        return new PersonDetails(userEntity.get());
    }
}