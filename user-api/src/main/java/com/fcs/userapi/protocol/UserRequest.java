package com.fcs.userapi.protocol;

public record UserRequest(
    String name,
    String email,
    String phone
) {

    public static UserRequest of(String name, String email, String phone) {
        return new UserRequest(name, email, phone);
    }
}
