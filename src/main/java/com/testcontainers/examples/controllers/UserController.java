package com.testcontainers.examples.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testcontainers.examples.dto.CreateUserDto;
import com.testcontainers.examples.models.UserModel;
import com.testcontainers.examples.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok().body(userService.allUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findById(UUID.fromString(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable String id) {
        userService.deleteById(UUID.fromString(id));

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<UserModel> createUser(@RequestBody CreateUserDto userInfo) {
        var newUser = userService.save(userInfo);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

}
