package com.example.springbootLab.service;

import com.example.springbootLab.dto.LightResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EarthKafkaListenerService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "blackhole-responses", groupId = "earth-group")
    public void listenBlackholeResponse(String message) {
        try {
            // Map JSON string to local LightResponseDTO
            LightResponseDTO response = objectMapper.readValue(message, LightResponseDTO.class);
            System.out.println("Earth received response: " + response.getResult());
        } catch (Exception e) {
            System.err.println("Failed to deserialize message: " + message);
            e.printStackTrace();
        }
    }
}
