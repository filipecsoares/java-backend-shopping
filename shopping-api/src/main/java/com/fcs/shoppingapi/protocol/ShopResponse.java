package com.fcs.shoppingapi.protocol;

import java.util.Date;
import java.util.List;

public class ShopResponse {

    private long id;
    private String userIdentifier;
    private Float total;
    private Date createdAt;
    private List<ItemRequest> items;

    public ShopResponse() {

    }

    public ShopResponse(long id, String userIdentifier, Float total, Date createdAt, List<ItemRequest> items) {
        this.id = id;
        this.userIdentifier = userIdentifier;
        this.total = total;
        this.createdAt = createdAt;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
