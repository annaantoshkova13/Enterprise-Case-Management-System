package org.example.enterprisecasemanagementsystem.teacher;

import org.example.enterprisecasemanagementsystem.course.GetCourseUseCase;
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

    public TeacherController(CreateTeacherUseCase createTeacherUseCase,
                             UpdateTeacherDepartmentUseCase updateTeacherDepartmentUseCase,
                             GetTeacherByIdUseCase getTeacherByIdUseCase,
                             ListTeachersUseCase listTeachersUseCase,
                             DeleteTeacherUseCase deleteTeacherUseCase) {
        this.createTeacherUseCase = createTeacherUseCase;
        this.updateTeacherDepartmentUseCase = updateTeacherDepartmentUseCase;
        this.getTeacherByIdUseCase = getTeacherByIdUseCase;
        this.listTeachersUseCase = listTeachersUseCase;
        this.deleteTeacherUseCase = deleteTeacherUseCase;
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return createTeacherUseCase.execute(teacher.getId(), teacher.getDepartment());
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

}
