package org.example.enterprisecasemanagementsystem.teacher;

import java.util.List;

public class ListTeachersUseCase {

    private final TeacherRepository teacherRepository;

    public ListTeachersUseCase(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> execute() {
        return teacherRepository.findAll();
    }
}
