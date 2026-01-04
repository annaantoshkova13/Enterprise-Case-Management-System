package org.example.enterprisecasemanagementsystem.course;

public class GetCourseUseCase {

    private final CourseRepository courseRepository;

    public GetCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course execute(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
}
