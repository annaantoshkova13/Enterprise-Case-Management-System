package org.example.enterprisecasemanagementsystem.course;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CreateCourseUseCase createCourseUseCase;
    private final UpdateCourseUseCase updateCourseUseCase;
    private final ListCourseUseCase listCourseUseCase;
    private final GetCourseUseCase getCourseUseCase;
    private final DeleteCourseUseCase deleteCourseUseCase;

    public CourseController(CreateCourseUseCase createCourseUseCase,
                            UpdateCourseUseCase updateCourseUseCase,
                            ListCourseUseCase listCourseUseCase,
                            GetCourseUseCase getCourseUseCase,
                            DeleteCourseUseCase deleteCourseUseCase) {
        this.createCourseUseCase = createCourseUseCase;
        this.updateCourseUseCase = updateCourseUseCase;
        this.listCourseUseCase = listCourseUseCase;
        this.getCourseUseCase = getCourseUseCase;
        this.deleteCourseUseCase = deleteCourseUseCase;
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return createCourseUseCase.execute(course.getTitle(), course.getDescription());
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return updateCourseUseCase.execute(id, course.getTitle(), course.getDescription());
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return getCourseUseCase.execute(id);
    }

    @GetMapping
    public List<Course> list() {
        return listCourseUseCase.execute();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteCourseUseCase.execute(id);
    }
}
