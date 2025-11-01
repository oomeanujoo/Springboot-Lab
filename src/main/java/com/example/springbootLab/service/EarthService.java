package com.example.springbootLab.service;

import com.example.springbootLab.config.MicroserviceConfig;
import com.example.springbootLab.dto.HttpRequestConfig;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class EarthService {

    private final HttpUrlConnectionService httpService;
    private final MicroserviceConfig microserviceConfig;

    public EarthService(HttpUrlConnectionService httpService, MicroserviceConfig microserviceConfig) {
        this.httpService = httpService;
        this.microserviceConfig = microserviceConfig;
    }

    public String getAllPlanets() {
        String url = microserviceConfig.getMicroserviceBaseUrl() + "/planets";

        HttpRequestConfig config = HttpRequestConfig.builder()
                .url(url)
                .method("GET")
                .headers(Map.of("Accept", "application/json"))
                .build();

        return httpService.invoke(config);
    }

    public String getPlanetByName(String name) {
        String url = microserviceConfig.getMicroserviceBaseUrl() + "/planets/" + name;

        HttpRequestConfig config = HttpRequestConfig.builder()
                .url(url)
                .method("GET")
                .headers(Map.of("Accept", "application/json"))
                .build();

        return httpService.invoke(config);
    }
}
