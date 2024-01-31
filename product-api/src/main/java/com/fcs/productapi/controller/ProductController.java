package com.fcs.productapi.controller;

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

import com.fcs.productapi.protocol.ProductRequest;
import com.fcs.productapi.protocol.ProductResponse;
import com.fcs.productapi.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(productService.getAll().stream().map(ProductResponse::fromProduct).toList());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponse>> findByCategoryId(@PathVariable final long categoryId) {
        return ResponseEntity.ok(productService.findByCategoryId(categoryId).stream().map(ProductResponse::fromProduct).toList());
    }

    @GetMapping("/{productIdentifier}")
    public ResponseEntity<ProductResponse> findByProductIdentifier(@PathVariable final String productIdentifier) {
        return ResponseEntity.ok(ProductResponse.fromProduct(productService.findByProductIdentifier(productIdentifier)));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody @Valid final ProductRequest productRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponse.fromProduct(productService.save(productRequest.toProduct())));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable final long productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }
}
