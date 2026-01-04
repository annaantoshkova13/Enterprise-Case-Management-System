package org.example.enterprisecasemanagementsystem;

import java.util.List;

public class ListUsersUseCase {

    private final UserRepository userRepository;

    public ListUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.findAll();
    }
}
