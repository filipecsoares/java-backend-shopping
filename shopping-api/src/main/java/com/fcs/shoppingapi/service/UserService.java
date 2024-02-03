package com.fcs.shoppingapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fcs.shoppingapi.protocol.UserResponse;

@Service
public class UserService {

    public UserResponse getUserByEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/cpf/" + email;
        ResponseEntity<UserResponse> response = restTemplate.getForEntity(url, UserResponse.class);
        return response.getBody();
    }
}
