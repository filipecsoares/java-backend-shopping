package com.fcs.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fcs.productapi.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
