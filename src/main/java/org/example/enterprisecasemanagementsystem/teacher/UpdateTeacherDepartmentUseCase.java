package org.example.enterprisecasemanagementsystem.teacher;

public class UpdateTeacherDepartmentUseCase {

    private final TeacherRepository teacherRepository;

    public UpdateTeacherDepartmentUseCase(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher execute(Long teacherId, String newDepartment) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        teacher.changeDepartment(newDepartment);
        return teacherRepository.save(teacher);
    }
}
