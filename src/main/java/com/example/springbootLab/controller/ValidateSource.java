package com.example.springbootLab.controller;

import com.example.springbootLab.entity.CustomerEntity;
import com.example.springbootLab.service.ValidateSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scope")
public class ValidateSource{

    @Autowired
    private ValidateSourceService validateSourceService;

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(validateSourceService.getAllCustomers());
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity createdCustomer = validateSourceService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerEntity updatedCustomer) {
        CustomerEntity customer = validateSourceService.updateCustomer(id, updatedCustomer.getPhoneNumber(), updatedCustomer.getEmail());
        return ResponseEntity.ok(customer);
    }
}
