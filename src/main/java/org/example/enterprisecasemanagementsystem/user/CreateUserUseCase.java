package org.example.enterprisecasemanagementsystem.user;

import org.example.enterprisecasemanagementsystem.exception.BusinessException;
import org.example.enterprisecasemanagementsystem.Role;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String email, String password, Role role) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new BusinessException("User with email " + email + " already exists");
        }

        User user = new User(email, password, role);
        return userRepository.save(user);
    }
}
