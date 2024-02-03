package com.fcs.shoppingapi.protocol;

public class ProductResponse {
    private Long id;
    private String productIdentifier;
    private String name;
    private String description;
    private Float price;

    public ProductResponse() {
        
    }

    public ProductResponse(Long id, String productIdentifier, String name, String description, Float price) {
        this.id = id;
        this.productIdentifier = productIdentifier;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
