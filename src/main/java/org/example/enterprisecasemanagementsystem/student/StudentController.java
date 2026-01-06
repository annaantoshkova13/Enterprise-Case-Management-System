package org.example.enterprisecasemanagementsystem.student;

import org.example.enterprisecasemanagementsystem.user.User;
import org.example.enterprisecasemanagementsystem.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final CreateStudentUseCase createStudentUseCase;
    private final UpdateStudentGroupUseCase updateStudentGroupUseCase;
    private final GetStudentByIdUseCase getStudentByIdUseCase;
    private final ListStudentsUseCase listStudentsUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;
    private final UserRepository userRepository;

    public StudentController(CreateStudentUseCase createStudentUseCase,
                             UpdateStudentGroupUseCase updateStudentGroupUseCase,
                             GetStudentByIdUseCase getStudentByIdUseCase,
                             ListStudentsUseCase listStudentsUseCase,
                             DeleteStudentUseCase deleteStudentUseCase,
                             UserRepository userRepository
                             ) {
        this.createStudentUseCase = createStudentUseCase;
        this.updateStudentGroupUseCase = updateStudentGroupUseCase;
        this.getStudentByIdUseCase = getStudentByIdUseCase;
        this.listStudentsUseCase = listStudentsUseCase;
        this.deleteStudentUseCase = deleteStudentUseCase;
        this.userRepository = userRepository;
    }

    @PostMapping
    public Student create(@RequestBody CreateStudentRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));

        return createStudentUseCase.execute(user, request.getGroupName());
    }

    @PutMapping("/{id}/group")
    public Student updateGroup(@PathVariable Long id, @RequestBody String newGroup) {
        return updateStudentGroupUseCase.execute(id, newGroup);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return getStudentByIdUseCase.execute(id);
    }

    @GetMapping
    public List<Student> list() {
        return listStudentsUseCase.execute();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteStudentUseCase.execute(id);
    }

    static class CreateStudentRequest {
        private String firstName;
        private String lastName;
        private String groupName;
        private Long userId;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }
}
