package com.example.secutiry.SecurityBook.modelDTO;


import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class LoginResponseDto {
    private String email;
    private String jwtToken;
    private String refreshToken;
}
