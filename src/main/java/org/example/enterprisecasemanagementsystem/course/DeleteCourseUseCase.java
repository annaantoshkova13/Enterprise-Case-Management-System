package org.example.enterprisecasemanagementsystem.course;

public class DeleteCourseUseCase {

    private final CourseRepository courseRepository;

    public DeleteCourseUseCase(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public void execute(Long id) {
        courseRepository.deleteById(id);
    }
}
