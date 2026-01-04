package org.example.enterprisecasemanagementsystem.student;

public class UpdateStudentGroupUseCase {

    private final StudentRepository studentRepository;

    public UpdateStudentGroupUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(Long studentId, String newGroup) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.changeGroup(newGroup);
        return studentRepository.save(student);
    }
}
