package com.example.springbootLab.service;

import com.example.springbootLab.dto.HttpRequestConfig;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpUrlConnectionService {

    public String invoke(HttpRequestConfig config) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(config.getUrl());
            connection = (HttpURLConnection) url.openConnection();

            // Dynamic method (GET/POST/etc)
            connection.setRequestMethod(config.getMethod().toUpperCase());
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Set headers dynamically
            if (config.getHeaders() != null) {
                for (var entry : config.getHeaders().entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            // Handle body for POST/PUT
            if (config.getBody() != null &&
                    (config.getMethod().equalsIgnoreCase("POST") || config.getMethod().equalsIgnoreCase("PUT"))) {
                connection.setDoOutput(true);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = config.getBody().getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            // Get response
            int status = connection.getResponseCode();
            InputStream is = (status >= 200 && status < 300)
                    ? connection.getInputStream()
                    : connection.getErrorStream();

            reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"" + e.getMessage() + "\"}";
        } finally {
            try {
                if (reader != null) reader.close();
                if (connection != null) connection.disconnect();
            } catch (IOException ignored) {}
        }
    }
}
