package com.example.authservice.service;
import com.example.authservice.dto.AuthRequest;
import com.example.authservice.dto.AuthResponse;
import com.example.authservice.model.AuthUser;
import com.example.authservice.repository.AuthUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class AuthService {

    private final AuthUserRepository authUserRepository;
    private  PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(AuthUserRepository authUserRepository,

                       JwtUtil jwtUtil) {
        this.authUserRepository = authUserRepository;
//this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse registerUser(AuthRequest request) {
        AuthUser user = new AuthUser();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        authUserRepository.save(user);

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token, Instant.now().plusSeconds(3600));
    }

    public AuthResponse authenticateUser(AuthRequest request) {
        AuthUser user = authUserRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token, Instant.now().plusSeconds(3600));
    }
}