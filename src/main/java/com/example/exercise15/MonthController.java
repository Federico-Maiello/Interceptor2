package com.example.exercise15;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/months")
public class MonthController {
    @GetMapping("/")
    public Month getMonth(@RequestAttribute("month") Month month) {
        return month;
    }
}