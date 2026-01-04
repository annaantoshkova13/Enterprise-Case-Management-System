package org.example.enterprisecasemanagementsystem.course;

import java.util.List;

public class ListCourseUseCase {

    private final CourseRepository courseRepository;

    public ListCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> execute() {
        return courseRepository.findAll();
    }
}
