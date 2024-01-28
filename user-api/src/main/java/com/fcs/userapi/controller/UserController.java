package com.fcs.userapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcs.userapi.protocol.UserRequest;
import com.fcs.userapi.protocol.UserResponse;
import com.fcs.userapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        final var response = userService.getAll().orElse(new ArrayList<>()).stream().map(UserResponse::of).toList();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getByEmail(@PathVariable String email) {
        final var response = userService.getUserByEmail(email).orElseThrow();
        return ResponseEntity.ok().body(UserResponse.of(response));
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        final var user = userService.save(request.toUserModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.of(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
