package com.example.exercise15;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Basic Controller!";
    }
}