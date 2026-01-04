package org.example.enterprisecasemanagementsystem.student;

public class DeleteStudentUseCase {

    private final StudentRepository studentRepository;

    public DeleteStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void execute(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
