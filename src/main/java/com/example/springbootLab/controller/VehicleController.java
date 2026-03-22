package com.example.springbootLab.controller;

import com.example.springbootLab.model.Vehicle;
import com.example.springbootLab.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService _vehicle;
    @GetMapping
    public ResponseEntity<List<Vehicle>> all() {
        return  ResponseEntity.ok(_vehicle.getAll());
    }
}
