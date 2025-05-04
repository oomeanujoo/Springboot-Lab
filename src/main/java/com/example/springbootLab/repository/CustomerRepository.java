package com.example.springbootLab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootLab.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
