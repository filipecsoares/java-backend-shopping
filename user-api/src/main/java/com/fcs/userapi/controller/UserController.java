package com.fcs.userapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcs.userapi.protocol.UserRequest;
import com.fcs.userapi.protocol.UserResponse;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/users")
public class UserController {
    
    public static List<UserResponse> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(UserResponse.of("1", "user1", "user1@ex.com", "123456789"));
        users.add(UserResponse.of("2", "user2", "user2@ex.com", "123456789"));
        users.add(UserResponse.of("3", "user3", "user3@ex.com", "123456789"));
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return users;
    }

    @GetMapping("/{email}")
    public UserResponse getUserByEmail(@PathVariable String email) {
        return users.stream().filter(user -> user.email().equals(email)).findFirst().orElse(null);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        final var id = String.valueOf(users.size() + 1);
        final var response = UserResponse.of(id, request.name(), request.email(), request.phone());
        users.add(response);
        return response;
    }

    @DeleteMapping("/{email}")
    public boolean deleteUser(@PathVariable String email) {
        return users.removeIf(user -> user.email().equals(email));
    }
}
