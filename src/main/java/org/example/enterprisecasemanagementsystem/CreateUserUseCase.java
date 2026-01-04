package org.example.enterprisecasemanagementsystem;

public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String email, String passwordHash, Role role) {
        User user = new User(null, email, passwordHash, role, null);
        return userRepository.save(user);
    }
}
