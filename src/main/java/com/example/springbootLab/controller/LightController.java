package com.example.springbootLab.controller;

import com.example.springbootLab.dto.LightRequestDTO;
import com.example.springbootLab.service.LightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/light")
public class LightController {

    private final LightService lightService;

    public LightController(LightService lightService) {
        this.lightService = lightService;
    }

    @PostMapping("/send")
    public String sendLight(@RequestBody LightRequestDTO light) {
        lightService.sendLight(light);
        return "Light sent to Blackhole!";
    }
}
