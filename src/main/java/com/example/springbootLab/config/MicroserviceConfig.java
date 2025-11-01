package com.example.springbootLab.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data                   // Lombok — generates getters, setters, toString, equals, hashCode
@Configuration          // Spring — marks this as a configuration class
public class MicroserviceConfig {

    @Value("${target.microservice.name}")
    private String microserviceName;

    @Value("${target.microservice.host}")
    private String microserviceHost;

    @Value("${target.microservice.port}")
    private int microservicePort;

    @Value("${target.microservice.base-path}")
    private String microserviceBasePath;

    public String getMicroserviceBaseUrl() {
        return "http://" + microserviceHost + ":" + microservicePort + microserviceBasePath;
    }
}
