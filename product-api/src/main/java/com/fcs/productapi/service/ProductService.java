package com.fcs.productapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fcs.productapi.model.Product;
import com.fcs.productapi.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCategoryIdr(final long categoryId) {
        return productRepository.getProductByCategory(categoryId);
    }

    public Product findByProductIdentifier(final String productIdentifier) {
        return productRepository.findByProductIdentifier(productIdentifier);
    }

    public Product save(final Product product) {
        return productRepository.save(product);
    }

    public void delete(final long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.delete(product.get());
        }
    }
}
