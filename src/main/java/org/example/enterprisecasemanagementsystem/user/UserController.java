package org.example.enterprisecasemanagementsystem.user;

import jakarta.validation.Valid;
import org.example.enterprisecasemanagementsystem.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserRequest request) {
        User user = createUserUseCase.execute(
                request.getEmail(),
                request.getPassword(),
                request.getRole()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @Valid @RequestBody UpdateUserRequest request) {
        User user = updateUserUseCase.execute(id, request.getEmail());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = getUserByIdUseCase.execute(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = listUsersUseCase.execute();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/role")
    public ResponseEntity<User> changeRole(@PathVariable Long id,
                                           @Valid @RequestBody ChangeRoleRequest request) {
        User user = changeUserRoleUseCase.execute(id, request.getRole());
        return ResponseEntity.ok(user);
    }

    public static class CreateUserRequest {
        private String email;
        private String password;
        private Role role;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }

        public Role getRole() { return role; }
        public void setRole(Role role) { this.role = role; }
    }

    public static class UpdateUserRequest {
        private String email;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    public static class ChangeRoleRequest {
        private Role role;

        public Role getRole() { return role; }
        public void setRole(Role role) { this.role = role; }
    }
}
