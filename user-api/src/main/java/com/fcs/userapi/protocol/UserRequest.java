package com.fcs.userapi.protocol;

import com.fcs.userapi.model.User;

public record UserRequest(
    String name,
    String email,
    String phone,
    String key
) {

    public static UserRequest of(String name, String email, String phone, String key) {
        return new UserRequest(name, email, phone, key);
    }

    public User toUserModel() {
        return new User(this.name(), this.email(), this.phone(), this.key());
    }
}
