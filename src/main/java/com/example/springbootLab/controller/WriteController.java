package com.example.springbootLab.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WriteController {
    private Map<Integer, String> map = new HashMap<>();

    @GetMapping("/getTest")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/postTest")
    public ResponseEntity<Map<Integer, String>> post(@RequestBody Map<String, String> payload) {
        int id = map.size() + 1;
        map.put(id, payload.get("val"));
        return ResponseEntity.ok(map);
    }
}
