package org.example.enterprisecasemanagementsystem;

public class CreateEserUseCase {

    private UserRepository userRepository;

    public CreateEserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String email, String passwordHash, Role role) {
        User user = new User(null, email, passwordHash, role, null);
        return userRepository.save(user);
    }
}
