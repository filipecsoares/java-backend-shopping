package com.fcs.shoppingapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fcs.exception.UserNotFoundException;
import com.fcs.shoppingapi.protocol.UserResponse;

@Service
public class UserService {

    public UserResponse getUserByEmail(String email, String key) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            final var userApiURL = "http://localhost:8080";
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(userApiURL + "/users/email/" + email);
            builder.queryParam("key", key);
            ResponseEntity<UserResponse> response = restTemplate.getForEntity(builder.toUriString(), UserResponse.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException("User not found: " + email);
        }
    }
}
