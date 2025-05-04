package com.example.springbootLab.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SingletonScopeService {

    private final String uuid;
    private final LocalDateTime createdTime;

    public SingletonScopeService() {
        this.uuid = UUID.randomUUID().toString();
        this.createdTime = LocalDateTime.now();
    }

    public String getDetails() {
        return "SingletonScopeService instance: " + uuid + " | Created at: " + createdTime;
    }
}
