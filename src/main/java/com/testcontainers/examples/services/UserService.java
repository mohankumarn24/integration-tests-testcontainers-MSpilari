package com.testcontainers.examples.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testcontainers.examples.dto.CreateUserDto;
import com.testcontainers.examples.models.UserModel;
import com.testcontainers.examples.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(CreateUserDto user) {
        var newUser = new UserModel(user.name());

        return userRepository.save(newUser);
    }

    public Page<UserModel> allUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public UserModel findById(UUID id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

}
