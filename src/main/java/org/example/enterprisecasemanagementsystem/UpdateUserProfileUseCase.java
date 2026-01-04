package org.example.enterprisecasemanagementsystem;

public class UpdateUserProfileUseCase {

    private UserRepository userRepository;

    public UpdateUserProfileUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long userId, String newEmail) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(newEmail);
        return userRepository.save(user);
    }
}
