package com.example.authservice.dto;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class AuthRequest {
    // Explicit Getter
    private String username;
    // Explicit Getter
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}