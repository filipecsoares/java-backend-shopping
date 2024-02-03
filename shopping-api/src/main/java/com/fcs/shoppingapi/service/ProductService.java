package com.fcs.shoppingapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fcs.shoppingapi.protocol.ProductResponse;

@Service
public class ProductService {

    public ProductResponse getProductByIdentifier(String productIdentifier) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/product/" + productIdentifier;
        ResponseEntity<ProductResponse> response = restTemplate.getForEntity(url, ProductResponse.class);
        return response.getBody();
    }
}
