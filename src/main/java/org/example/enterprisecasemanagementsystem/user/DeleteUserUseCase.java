package org.example.enterprisecasemanagementsystem.user;

import org.example.enterprisecasemanagementsystem.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCase {

    private final UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User", "id", userId);
        }
        userRepository.deleteById(userId);
    }
}
