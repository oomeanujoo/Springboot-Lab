package com.example.springbootLab.controller;

import com.example.springbootLab.service.SingletonScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springbootLab.dto.ScopeResponseDTO;
import org.springframework.beans.factory.ObjectFactory;
import com.example.springbootLab.service.PrototypeScopeService;


@RestController
@RequestMapping("/scope")
public class DemoScopeController {

    @Autowired
    private SingletonScopeService singletonService;

    @Autowired
    private ObjectFactory<PrototypeScopeService> prototypeFactory;


    @GetMapping("/singleton")
    public String testSingletonScope() {
        return singletonService.getDetails();
    }

    @GetMapping("/prototype")
    public ScopeResponseDTO testPrototypeScope() {
        return prototypeFactory.getObject().getDetails();
    }
}
