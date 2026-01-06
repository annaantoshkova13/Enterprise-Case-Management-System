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
    public Course create(@RequestBody CreateCourseRequest request) {
        return createCourseUseCase.execute(
                request.getTitle(),
                request.getDescription(),
                request.getTeacherId()
        );
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody UpdateCourseRequest request) {
        return updateCourseUseCase.execute(id, request.getTitle(), request.getDescription());
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

    static class CreateCourseRequest {
        private String title;
        private String description;
        private Long teacherId;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public Long getTeacherId() { return teacherId; }
        public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
    }

    static class UpdateCourseRequest {
        private String title;
        private String description;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}
