package org.example.enterprisecasemanagementsystem;

import java.util.Optional;

public class GetUserByIdUseCase {

    private UserRepository userRepository;

    public GetUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> execute(Long id) {
        return userRepository.findById(id);
    }
}
