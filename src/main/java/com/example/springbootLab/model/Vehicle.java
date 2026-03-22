package com.example.springbootLab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    private Long id;
    private String owner;
    private String type;
    private String plateNumber;
}
