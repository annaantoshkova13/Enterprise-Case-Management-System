package org.example.enterprisecasemanagementsystem.user;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListUsersUseCase {

    private final UserRepository userRepository;

    public ListUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.findAll();
    }
}
