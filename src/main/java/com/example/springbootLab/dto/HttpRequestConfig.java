package com.example.springbootLab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data                   // Generates getters, setters, toString, equals, hashCode
@Builder                // Enables builder pattern (clean object creation)
@NoArgsConstructor      // Empty constructor
@AllArgsConstructor     // All-args constructor
public class HttpRequestConfig {
    private String url;
    private String method; // GET, POST, PUT, etc.
    private Map<String, String> headers;
    private String body; // optional for POST/PUT
}
