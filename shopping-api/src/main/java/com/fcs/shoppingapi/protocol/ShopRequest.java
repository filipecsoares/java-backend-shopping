package com.fcs.shoppingapi.protocol;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ShopRequest {
    @NotBlank
    private String userIdentifier;
    @NotNull
    private Float total;
    @NotNull
    private Date createdAt;
    @NotNull
    private List<ItemRequest> items;

    public ShopRequest() {

    }

    public ShopRequest(String userIdentifier, Float total, Date createdAt, List<ItemRequest> items) {
        this.userIdentifier = userIdentifier;
        this.total = total;
        this.createdAt = createdAt;
        this.items = items;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }
}
