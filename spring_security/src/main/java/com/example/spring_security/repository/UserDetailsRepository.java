package com.example.spring_security.repository;

import com.example.spring_security.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserDetailsRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String userName);
}
