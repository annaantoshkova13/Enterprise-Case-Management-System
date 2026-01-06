package org.example.enterprisecasemanagementsystem.user;

import org.example.enterprisecasemanagementsystem.exception.ResourceNotFoundException;

import java.util.Optional;

public class GetUserByIdUseCase {

    private final UserRepository userRepository;

    public GetUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}
