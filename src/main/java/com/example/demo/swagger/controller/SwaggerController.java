package com.example.demo.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/usage")
public class SwaggerController {

    @GetMapping
    public String api() { return "redirect:/swagger-ui.html"; }
}