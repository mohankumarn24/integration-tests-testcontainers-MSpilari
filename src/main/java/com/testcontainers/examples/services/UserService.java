package com.testcontainers.examples.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testcontainers.examples.dto.CreateUserDto;
import com.testcontainers.examples.dto.UserResponseDto;
import com.testcontainers.examples.models.UserModel;
import com.testcontainers.examples.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDto save(CreateUserDto user) {
        var newUser = new UserModel(user.name());

        var userCreated = userRepository.save(newUser);

        return new UserResponseDto(userCreated.getId(), userCreated.getName());
    }

    public Page<UserResponseDto> allUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(user -> new UserResponseDto(user.getId(), user.getName()));
    }

    public UserResponseDto findById(UUID id) {
        var user = userRepository.findById(id).orElseThrow();
        return new UserResponseDto(user.getId(), user.getName());
    }

    @Transactional
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

}
