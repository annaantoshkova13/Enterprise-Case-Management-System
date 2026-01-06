package org.example.enterprisecasemanagementsystem.course;

import jakarta.transaction.Transactional;
import org.example.enterprisecasemanagementsystem.teacher.Teacher;
import org.example.enterprisecasemanagementsystem.teacher.TeacherRepository;

public class CreateCourseUseCase {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository; // Добавляем TeacherRepository

    public CreateCourseUseCase(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    @Transactional
    public Course execute(String title, String description, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + teacherId));

        Course course = new Course(title, description, teacher);
        return courseRepository.save(course);
    }
}
