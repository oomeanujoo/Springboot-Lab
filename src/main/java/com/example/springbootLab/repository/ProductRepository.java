package com.example.springbootLab.repository;  // Add the correct package declaration

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootLab.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // Your custom query methods (if any) can go here
}
