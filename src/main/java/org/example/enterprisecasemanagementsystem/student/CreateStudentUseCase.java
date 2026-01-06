package org.example.enterprisecasemanagementsystem.student;

import org.example.enterprisecasemanagementsystem.user.User;


public class CreateStudentUseCase {

    private final StudentRepository studentRepository;

    public CreateStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(User user, String groupName) {
        Student student = new Student(user, groupName);
        return studentRepository.save(student);
    }

    public Student execute(String firstName, String lastName, String groupName, User user) {
        Student student = new Student(firstName, lastName, groupName, user);
        return studentRepository.save(student);
    }
}
