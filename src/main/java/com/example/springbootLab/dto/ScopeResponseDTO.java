package com.example.springbootLab.dto;

import java.time.LocalDateTime;

public class ScopeResponseDTO {
    private String scopeType;
    private String uuid;
    private LocalDateTime createdTime;

    public ScopeResponseDTO(String scopeType, String uuid, LocalDateTime createdTime) {
        this.scopeType = scopeType;
        this.uuid = uuid;
        this.createdTime = createdTime;
    }

    public String getScopeType() {
        return scopeType;
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
