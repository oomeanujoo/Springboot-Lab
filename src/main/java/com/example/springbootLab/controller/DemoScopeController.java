package com.example.springbootLab.controller;

import com.example.springbootLab.service.SingletonScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scope")
public class DemoScopeController {

    @Autowired
    private SingletonScopeService singletonService;

    @GetMapping("/singleton")
    public String testSingletonScope() {
        return singletonService.getDetails();
    }
}
