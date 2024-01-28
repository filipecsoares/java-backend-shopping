package com.fcs.userapi.protocol;

import java.time.LocalDateTime;

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
}
