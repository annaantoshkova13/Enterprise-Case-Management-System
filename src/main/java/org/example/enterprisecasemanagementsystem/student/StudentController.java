package org.example.enterprisecasemanagementsystem.student;

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

    public StudentController(CreateStudentUseCase createStudentUseCase,
                             UpdateStudentGroupUseCase updateStudentGroupUseCase,
                             GetStudentByIdUseCase getStudentByIdUseCase,
                             ListStudentsUseCase listStudentsUseCase,
                             DeleteStudentUseCase deleteStudentUseCase) {
        this.createStudentUseCase = createStudentUseCase;
        this.updateStudentGroupUseCase = updateStudentGroupUseCase;
        this.getStudentByIdUseCase = getStudentByIdUseCase;
        this.listStudentsUseCase = listStudentsUseCase;
        this.deleteStudentUseCase = deleteStudentUseCase;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return createStudentUseCase.execute(student.getUser(), student.getGroup());
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
}
