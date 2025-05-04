package com.example.springbootLab.service;

import com.example.springbootLab.dto.ScopeResponseDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Scope("prototype")
public class PrototypeScopeService {

    private final String uuid;
    private final LocalDateTime createdTime;

    public PrototypeScopeService() {
        this.uuid = UUID.randomUUID().toString();
        this.createdTime = LocalDateTime.now();
    }

    public ScopeResponseDTO getDetails() {
        return new ScopeResponseDTO("Prototype", uuid, createdTime);
    }
}
