package com.example.secutiry.SecurityBook.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping
    public ResponseEntity<String> getUserData() {
        return ResponseEntity.ok("Данные пользователя");
    }
}
