package com.example.userservice.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserProfile {
    @Id
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
}