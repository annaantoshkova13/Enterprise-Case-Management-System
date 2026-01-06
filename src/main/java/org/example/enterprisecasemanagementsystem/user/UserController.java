package org.example.enterprisecasemanagementsystem.user;

import org.example.enterprisecasemanagementsystem.Role;
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
    private final ChangeUserRoleUseCase changeUserRoleUseCase;

    public UserController(CreateUserUseCase createUserUseCase,
                          UpdateUserProfileUseCase updateUserProfileUseCase,
                          GetUserByIdUseCase getUserByIdUseCase,
                          ListUsersUseCase listUsersUseCase,
                          DeleteUserUseCase deleteUserUseCase,
                          ChangeUserRoleUseCase changeUserRoleUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserProfileUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.listUsersUseCase = listUsersUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.changeUserRoleUseCase = changeUserRoleUseCase;
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest request) {
        return createUserUseCase.execute(
                request.getEmail(),
                request.getPasswordHash(),
                request.getRole()
        );
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        // Используйте только email, так как passwordHash нельзя так просто обновлять
        return updateUserUseCase.execute(id, request.getEmail(), request.getEmail(), request.getRole());
    }

    @PutMapping("/{id}/role")
    public User changeRole(@PathVariable Long id, @RequestBody ChangeRoleRequest request) {
        return changeUserRoleUseCase.execute(id, request.getRole());
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

    static class CreateUserRequest {
        private String email;
        private String passwordHash;
        private Role role;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPasswordHash() { return passwordHash; }
        public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

        public Role getRole() { return role; }
        public void setRole(Role role) { this.role = role; }
    }

    static class UpdateUserRequest {
        private String email;
        private Role role;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public Role getRole() { return role; }
        public void setRole(Role role) { this.role = role; }
    }

    static class ChangeRoleRequest {
        private Role role;

        public Role getRole() { return role; }
        public void setRole(Role role) { this.role = role; }
    }
}
