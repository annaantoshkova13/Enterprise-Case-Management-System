package org.example.enterprisecasemanagementsystem.teacher;

public class GetTeacherByIdUseCase {

    private final TeacherRepository teacherRepository;

    public GetTeacherByIdUseCase(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher execute(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }
}
