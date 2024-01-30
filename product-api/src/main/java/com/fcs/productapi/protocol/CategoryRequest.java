package com.fcs.productapi.protocol;

import jakarta.validation.constraints.NotNull;

public class CategoryRequest {
    @NotNull
    private Long id;
    private String name;

    public CategoryRequest() {

    }

    public CategoryRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
