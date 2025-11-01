package com.example.springbootLab.service;

import com.example.springbootLab.entity.CustomerEntity;
import com.example.springbootLab.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.time.LocalDate;

@Service
public class ValidateSourceService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public CustomerEntity createCustomer(CustomerEntity customer) {
        // Set default values if necessary
        customer.setIsActive(false); // Assuming new customers are active by default
        customer.setDateOfBirth(LocalDate.now()); // Set current system date as date of birth
        return customerRepository.save(customer);
    }

    @Transactional
    public CustomerEntity updateCustomer(Long id, String newPhoneNumber, String newEmail) {
        CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (!customer.getPhoneNumber().equals(newPhoneNumber) && !customer.getEmail().equals(newEmail)) {
            customer.setPhoneNumber(newPhoneNumber);
            customer.setPhoneNumber(newEmail);
            customer.setIsActive(true); // Mark as active if phone number is updated
        } else {
            customer.setIsActive(false); // Mark as inactive if phone number remains the same
        }

        return customerRepository.save(customer);
    }


    @Transactional
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }
}
