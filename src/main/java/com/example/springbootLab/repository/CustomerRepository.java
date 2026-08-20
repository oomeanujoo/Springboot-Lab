package com.example.springbootLab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootLab.entity.CustomerEntity;
import java.util.List; // needed for the findByIsActiveTrue derived query return type

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);

    List<CustomerEntity> findByIsActiveTrue(); // derived query — filters active customers without writing SQL
}
