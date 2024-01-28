package com.fcs.userapi.protocol;

import java.time.LocalDateTime;

import com.fcs.userapi.model.User;

public record UserResponse(
    String id,
    String name,
    String email,
    String phone,
    LocalDateTime createdAt
) {
    public static UserResponse of(String id, String name, String email, String phone) {
        return new UserResponse(id, name, email, phone, LocalDateTime.now());
    }

    public static UserResponse of(User user) {
        return new UserResponse(user.getId().toString(), user.getName(), user.getEmail(), user.getPhone(), user.getCreatedAt());
        
    }
}
