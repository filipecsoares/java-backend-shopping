package com.fcs.shoppingapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fcs.exception.UserNotFoundException;
import com.fcs.shoppingapi.protocol.UserResponse;

@Service
public class UserService {

    @Value("${USER_API_URL:http://localhost:8080/users/}")
    private String userApiURL;

    public UserResponse getUserByEmail(String email, String key) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            final var url = userApiURL + "email/" + email;
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            builder.queryParam("key", key);
            ResponseEntity<UserResponse> response = restTemplate.getForEntity(builder.toUriString(),
                    UserResponse.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException("User not found: " + email);
        }
    }
}
