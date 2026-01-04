package org.example.enterprisecasemanagementsystem.student;

public class GetStudentByIdUseCase {

    private final StudentRepository studentRepository;

    public GetStudentByIdUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
