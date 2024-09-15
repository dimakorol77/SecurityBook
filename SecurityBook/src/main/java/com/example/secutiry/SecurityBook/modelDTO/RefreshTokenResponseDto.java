package com.example.secutiry.SecurityBook.modelDTO;


import lombok.Data;

@Data
public class RefreshTokenResponseDto {
    private String jwtToken;
    private String refreshToken;
}
