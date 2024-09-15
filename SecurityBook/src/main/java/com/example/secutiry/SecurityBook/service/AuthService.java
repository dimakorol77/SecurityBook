package com.example.secutiry.SecurityBook.service;


import com.example.secutiry.SecurityBook.modelDTO.*;
import com.example.secutiry.SecurityBook.model.AppUser;
import com.example.secutiry.SecurityBook.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtSecurityService jwtSecurityService;
    private final AuthenticationManager authenticationManager;

    public AppUser register(RegisterRequestDto registerRequestDto) {
        AppUser appUser = new AppUser();
        appUser.setEmail(registerRequestDto.getEmail());
        appUser.setFullName(registerRequestDto.getFullName());
        appUser.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        appUser.setRole(com.example.secutiry.SecurityBook.enums.AppRole.USER);

        return appUserRepository.save(appUser);
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword()
                )
        );

        var user = appUserRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow();

        var jwtToken = jwtSecurityService.generateToken(user);
        var refreshToken = jwtSecurityService.generateToken(user);

        return LoginResponseDto.builder()
                .email(user.getEmail())
                .jwtToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    // Метод refresh() можно реализовать по аналогии
}
