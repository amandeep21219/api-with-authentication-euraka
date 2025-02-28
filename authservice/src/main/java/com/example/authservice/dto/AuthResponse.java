package com.example.authservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Getter
@Setter
public class AuthResponse {
    private String token;
    private Instant expiresAt;

    public AuthResponse(String token, Instant instant) {
    }
}