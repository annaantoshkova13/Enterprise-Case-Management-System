package org.example.enterprisecasemanagementsystem.teacher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherUseCaseConfig {

    @Bean
    public CreateTeacherUseCase createTeacherUseCase(TeacherRepository repository){
        return new CreateTeacherUseCase(repository);
    }

    @Bean
    public UpdateTeacherDepartmentUseCase updateTeacherDepartmentUseCase(TeacherRepository repository){
        return new UpdateTeacherDepartmentUseCase(repository);
    }

    @Bean
    public DeleteTeacherUseCase deleteTeacherUseCase(TeacherRepository repository){
        return new DeleteTeacherUseCase(repository);
    }

    @Bean
    public GetTeacherByIdUseCase getTeacherByIdUseCase(TeacherRepository repository){
        return new GetTeacherByIdUseCase(repository);
    }

    @Bean
    public ListTeachersUseCase listTeachersUseCase(TeacherRepository repository){
        return new ListTeachersUseCase(repository);
    }
}
