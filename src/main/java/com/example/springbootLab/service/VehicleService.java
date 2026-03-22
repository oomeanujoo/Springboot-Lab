package com.example.springbootLab.service;

import com.example.springbootLab.model.Vehicle;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class VehicleService {
    private final Map<Long, Vehicle> db = new HashMap<>();
    private Long counter = 1L;
    public List<Vehicle>getAll() {
        return new ArrayList<>(db.values());
    }
}
