package com.example.userservice.controller;
import com.example.userservice.dto.UserProfileDTO;
import com.example.userservice.model.UserProfile;
import com.example.userservice.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserProfileService userProfileService;

    public UserController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/{userId}/profile")
    public ResponseEntity<UserProfile> createProfile(
            @PathVariable String userId,
            @RequestBody UserProfileDTO dto) {
        return ResponseEntity.ok(userProfileService.createUserProfile(userId, dto));
    }

    @GetMapping("/{userId}/profile")
    public ResponseEntity<UserProfile> getProfile(@PathVariable String userId) {
        return ResponseEntity.ok(userProfileService.getUserProfile(userId));
    }
}

