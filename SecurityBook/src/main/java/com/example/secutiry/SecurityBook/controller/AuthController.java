package com.example.secutiry.SecurityBook.controller;


import com.example.secutiry.SecurityBook.service.AuthService;
import com.example.secutiry.SecurityBook.modelDTO.*;
import com.example.secutiry.SecurityBook.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody RegisterRequestDto request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

    // Метод refresh() можно добавить по аналогии
}
