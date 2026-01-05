package org.example.enterprisecasemanagementsystem.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserProfileUseCase updateUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase,
                          UpdateUserProfileUseCase updateUserProfileUseCase,
                          GetUserByIdUseCase getUserByIdUseCase,
                          ListUsersUseCase listUsersUseCase,
                          DeleteUserUseCase deleteUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserProfileUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.listUsersUseCase = listUsersUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return createUserUseCase.execute(user.getEmail(), user.getPasswordHash(), user.getRole());
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return updateUserUseCase.execute(id, updatedUser.getEmail(), updatedUser.getPasswordHash(), updatedUser.getRole());
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return getUserByIdUseCase.execute(id);
    }

    @GetMapping
    public List<User> listUsers() {
        return listUsersUseCase.execute();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        deleteUserUseCase.execute(id);
    }
}
