package org.example.enterprisecasemanagementsystem;

public class ChangeUserRoleUseCase {

    private final UserRepository userRepository;

    public  ChangeUserRoleUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long userId, Role newRole) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(newRole);
        return userRepository.save(user);
    }
}
