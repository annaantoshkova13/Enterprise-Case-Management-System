package org.example.enterprisecasemanagementsystem.user;

import org.example.enterprisecasemanagementsystem.Role;
import org.example.enterprisecasemanagementsystem.exception.BusinessException;
import org.example.enterprisecasemanagementsystem.exception.ResourceNotFoundException;

public class UpdateUserProfileUseCase {

    private final UserRepository userRepository;

    public UpdateUserProfileUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long userId, String newEmail) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        // Проверка, не занят ли email другим пользователем
        if (!user.getEmail().equals(newEmail) &&
                userRepository.findByEmail(newEmail).isPresent()) {
            throw new BusinessException("Email " + newEmail + " is already taken");
        }

        user.setEmail(newEmail);
        return userRepository.save(user);
    }

}
