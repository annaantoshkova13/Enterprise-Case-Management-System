package org.example.enterprisecasemanagementsystem.student;
import java.util.List;

public class ListStudentsUseCase {

    private final StudentRepository studentRepository;

    public ListStudentsUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> execute() {
        return studentRepository.findAll();
    }

}
