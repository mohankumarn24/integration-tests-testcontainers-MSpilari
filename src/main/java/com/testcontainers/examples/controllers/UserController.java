package com.testcontainers.examples.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testcontainers.examples.dto.CreateUserDto;
import com.testcontainers.examples.dto.ErrorResponseDto;
import com.testcontainers.examples.models.UserModel;
import com.testcontainers.examples.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<Page<UserModel>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<UserModel> users = userService.allUsers(pageable);

        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find user by id", description = "Return 200 if the user exists.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Wrong/not valid UUID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "default error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public ResponseEntity<UserModel> getUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findById(UUID.fromString(id)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "User deleted"),
            @ApiResponse(responseCode = "400", description = "Wrong/not valid UUID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "default error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public ResponseEntity<?> deleteUserById(@PathVariable String id) {
        userService.deleteById(UUID.fromString(id));

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    @Operation(summary = "Create a new user", description = "Return 201 if the user was successfully created.")
    @ApiResponse(responseCode = "201", description = "User created succesfully.")
    public ResponseEntity<UserModel> createUser(@RequestBody CreateUserDto userInfo) {
        var newUser = userService.save(userInfo);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

}
