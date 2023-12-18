package com.example.backend2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pagcontroller {

    @GetMapping("/")
    public String login() {
        return "login";
    }

}
