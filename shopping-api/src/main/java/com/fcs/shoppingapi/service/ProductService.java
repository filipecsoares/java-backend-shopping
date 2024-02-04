package com.fcs.shoppingapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fcs.exception.ProductNotFoundException;
import com.fcs.shoppingapi.protocol.ProductResponse;

@Service
public class ProductService {

    @Value("${PRODUCT_API_URL:http://localhost:8081/products/}")
    private String productApiURL;

    public ProductResponse getProductByIdentifier(String productIdentifier) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            final var url = productApiURL + productIdentifier;
            ResponseEntity<ProductResponse> response = restTemplate.getForEntity(url, ProductResponse.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new ProductNotFoundException("Product not found: " + productIdentifier);
        }
    }
}
