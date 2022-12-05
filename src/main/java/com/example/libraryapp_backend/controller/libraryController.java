package com.example.libraryapp_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class libraryController {
    @GetMapping("/")
    public String Homepage(){
    return "Welcome to my website";
    }

    @PostMapping("/adminlogin")
    public String Admin(){
        return "Admin Login";
    }

    @PostMapping("/userreg")
    public String UserReg(){
        return "User Registration";
    }
}
