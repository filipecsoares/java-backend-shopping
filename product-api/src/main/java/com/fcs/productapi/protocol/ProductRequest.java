package com.fcs.productapi.protocol;

import com.fcs.productapi.model.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {
    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Float price;
    @NotNull
    private CategoryRequest category;

    public ProductRequest() {

    }

    public ProductRequest(String productIdentifier, String name, String description, Float price, CategoryRequest category) {
        this.productIdentifier = productIdentifier;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product toProduct() {
        return new Product(name, price, description, productIdentifier, category.toCategory());
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public CategoryRequest getCategory() {
        return category;
    }

    public void setCategory(CategoryRequest category) {
        this.category = category;
    }
}
