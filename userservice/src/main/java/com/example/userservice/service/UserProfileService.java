package com.example.userservice.service;
import com.example.userservice.dto.UserProfileDTO;
import com.example.userservice.model.UserProfile;
import com.example.userservice.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile createUserProfile(String userId, UserProfileDTO dto) {
        UserProfile profile = new UserProfile();
        profile.setUserId(userId);
        profile.setEmail(dto.getEmail());
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        return userProfileRepository.save(profile);
    }

    public UserProfile getUserProfile(String userId) {
        return userProfileRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User profile not found"));
    }
}