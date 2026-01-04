package org.example.enterprisecasemanagementsystem.course;

public class UpdateCourseUseCase {

    private final CourseRepository courseRepository;

    public UpdateCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course execute(Long id, String name, String description) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.update(name, description);
        return courseRepository.save(course);
    }
}
