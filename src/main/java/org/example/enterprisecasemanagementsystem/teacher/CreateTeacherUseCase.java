package org.example.enterprisecasemanagementsystem.teacher;

import org.example.enterprisecasemanagementsystem.user.User;

public class CreateTeacherUseCase {

    private final TeacherRepository teacherRepository;

    public CreateTeacherUseCase(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher execute(User user, String department) {
        Teacher teacher = new Teacher(user, department);
        return teacherRepository.save(teacher);
    }
}
