package com.example.secutiry.SecurityBook.modelDTO;


import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
