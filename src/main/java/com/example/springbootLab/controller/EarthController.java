package com.example.springbootLab.controller;

import com.example.springbootLab.service.EarthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/earth")
public class EarthController {

    private final EarthService earthService;

    public EarthController(EarthService earthService) {
        this.earthService = earthService;
    }

    @GetMapping("/planets")
    public ResponseEntity<String> getAllPlanets() {
        return ResponseEntity.ok(earthService.getAllPlanets());
    }

    @GetMapping("/planets/{name}")
    public ResponseEntity<String> getPlanetByName(@PathVariable String name) {
        return ResponseEntity.ok(earthService.getPlanetByName(name));
    }
}
