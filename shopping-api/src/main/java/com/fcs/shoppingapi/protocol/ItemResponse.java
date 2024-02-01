package com.fcs.shoppingapi.protocol;

public class ItemResponse {

    private String productIdentifier;
    private Float price;

    public ItemResponse() {

    }

    public ItemResponse(String productIdentifier, Float price) {
        this.productIdentifier = productIdentifier;
        this.price = price;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
