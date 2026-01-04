package org.example.enterprisecasemanagementsystem.student;

import org.apache.catalina.Group;
import org.example.enterprisecasemanagementsystem.user.User;

import javax.swing.*;

public class CreateStudentUseCase {

    private final StudentRepository studentRepository;

    public CreateStudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student execute(User user, Group group) {
        Student student = new Student(user, group);
        return studentRepository.save(student);
    }
}
