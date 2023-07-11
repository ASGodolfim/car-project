package com.car.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/carros")
public class CarProjectController {

    @GetMapping(value = "/get")
    public String get(){
        return "Greeting";
    }
}
