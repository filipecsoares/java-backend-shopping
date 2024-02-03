package com.fcs.shoppingapi.protocol;

import com.fcs.shoppingapi.model.Item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemRequest {

    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

    public ItemRequest() {

    }

    public ItemRequest(String productIdentifier, Float price) {
        this.productIdentifier = productIdentifier;
        this.price = price;
    }

    public Item toModel() {
        return new Item(productIdentifier, price);
    }

    public static ItemRequest from(Item item) {
        return new ItemRequest(item.getProductIdentifier(), item.getPrice());
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
