package org.example.enterprisecasemanagementsystem.teacher;

import org.example.enterprisecasemanagementsystem.course.GetCourseUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final GetTeacherByIdUseCase getTeacherByIdUseCase;
    private  final GetTeacherByIdUseCase getTeacherUseCase;
    private final CreateTeacherUseCase createTeacherUseCase;
    private final DeleteTeacherUseCase deleteTeacherUseCase;

}
