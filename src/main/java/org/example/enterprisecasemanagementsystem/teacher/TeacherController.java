package org.example.enterprisecasemanagementsystem.teacher;
import org.example.enterprisecasemanagementsystem.user.User;
import org.example.enterprisecasemanagementsystem.user.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final CreateTeacherUseCase createTeacherUseCase;
    private final UpdateTeacherDepartmentUseCase updateTeacherDepartmentUseCase;
    private final GetTeacherByIdUseCase getTeacherByIdUseCase;
    private final ListTeachersUseCase listTeachersUseCase;
    private final DeleteTeacherUseCase deleteTeacherUseCase;
    private final UserRepository userRepository;

    public TeacherController(CreateTeacherUseCase createTeacherUseCase,
                             UpdateTeacherDepartmentUseCase updateTeacherDepartmentUseCase,
                             GetTeacherByIdUseCase getTeacherByIdUseCase,
                             ListTeachersUseCase listTeachersUseCase,
                             DeleteTeacherUseCase deleteTeacherUseCase,
                             UserRepository userRepository) {
        this.createTeacherUseCase = createTeacherUseCase;
        this.updateTeacherDepartmentUseCase = updateTeacherDepartmentUseCase;
        this.getTeacherByIdUseCase = getTeacherByIdUseCase;
        this.listTeachersUseCase = listTeachersUseCase;
        this.deleteTeacherUseCase = deleteTeacherUseCase;
        this.userRepository = userRepository;
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody CreateTeacherRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return createTeacherUseCase.execute(
                request.getFirstName(),
                request.getLastName(),
                request.getDepartment(),
                user
        );
    }

    @PutMapping("/{id}/department")
    public Teacher updateTeacherDepartment(@PathVariable Long id, @RequestParam String department) {
        return updateTeacherDepartmentUseCase.execute(id, department);
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return getTeacherByIdUseCase.execute(id);
    }

    @GetMapping
    public List<Teacher> listTeachers() {
        return listTeachersUseCase.execute();
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        deleteTeacherUseCase.execute(id);
    }

    static class CreateTeacherRequest {
        private String firstName;
        private String lastName;
        private String department;
        private Long userId;

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
    }
}
