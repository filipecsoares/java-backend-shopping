package com.fcs.productapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fcs.exception.CategoryNotFoundException;
import com.fcs.exception.ProductNotFoundException;
import com.fcs.productapi.model.Product;
import com.fcs.productapi.repository.CategoryRepository;
import com.fcs.productapi.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCategoryId(final long categoryId) {
        return productRepository.getProductByCategory(categoryId);
    }

    public Product findByProductIdentifier(final String productIdentifier) {
        final var product = productRepository.findByProductIdentifier(productIdentifier);
        if (product == null) {
            throw new ProductNotFoundException("Product not found: " + productIdentifier);
        }
        return product;
    }

    public Product save(final Product product) {
        Boolean hasCategory = categoryRepository.existsById(product.getCategory().getId());
        if (!hasCategory) {
            throw new CategoryNotFoundException("Category not found: " + product.getCategory().getId());
        }
        return productRepository.save(product);
    }

    public void delete(final long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.delete(product.get());
        }
        throw new ProductNotFoundException("Product not found: " + productId);
    }
}
