package com.example.authservice.repository;
import com.example.authservice.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
    Optional<AuthUser> findByUsername(String username);
}