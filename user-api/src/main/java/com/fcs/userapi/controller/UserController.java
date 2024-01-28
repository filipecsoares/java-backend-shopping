package com.fcs.userapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
