package org.example.enterprisecasemanagementsystem.course;

import jakarta.transaction.Transactional;

public class CreateCourseUseCase {

    private final CourseRepository courseRepository;

    public CreateCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public Course execute(String name, String description) {
        return courseRepository.save(new Course());
    }
}
