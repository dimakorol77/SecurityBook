package com.example.secutiry.SecurityBook.modelDTO;


import lombok.Data;

@Data
public class RegisterRequestDto {
    private String fullName;
    private String email;
    private String password;
}
