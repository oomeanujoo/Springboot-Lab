package com.example.springbootLab.service;

import com.example.springbootLab.dto.LightRequestDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LightService {

    private final KafkaTemplate<String, LightRequestDTO> kafkaTemplate;

    public LightService(KafkaTemplate<String, LightRequestDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLight(LightRequestDTO light) {
        kafkaTemplate.send("blackhole-requests", light);
        System.out.println("Earth sent light: " + light.getMessage());
    }
}
