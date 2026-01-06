package org.example.enterprisecasemanagementsystem.teacher;

import org.example.enterprisecasemanagementsystem.user.User;

public class CreateTeacherUseCase {

    private final TeacherRepository teacherRepository;

    public CreateTeacherUseCase(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher execute(User user, String department) {
        Teacher teacher = new Teacher("", "", department, user); // Укажите firstName и lastName
        return teacherRepository.save(teacher);
    }

    public Teacher execute(String firstName, String lastName, String department, User user) {
        Teacher teacher = new Teacher(firstName, lastName, department, user);
        return teacherRepository.save(teacher);
    }
}
