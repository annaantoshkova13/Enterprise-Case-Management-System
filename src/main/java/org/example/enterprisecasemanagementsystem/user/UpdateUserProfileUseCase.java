package org.example.enterprisecasemanagementsystem.user;

import org.example.enterprisecasemanagementsystem.Role;

public class UpdateUserProfileUseCase {

    private UserRepository userRepository;

    public UpdateUserProfileUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long userId, String email, String newEmail, Role role) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(newEmail);
        return userRepository.save(user);
    }
}
