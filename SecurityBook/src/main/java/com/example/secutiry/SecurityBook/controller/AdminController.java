package com.example.secutiry.SecurityBook.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping
    public ResponseEntity<String> getAdminData() {
        return ResponseEntity.ok("Данные администратора");
    }
}
