package org.example.enterprisecasemanagementsystem.course;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseUseCaseConfig {

    @Bean
    public CreateCourseUseCase createCourseUseCase(CourseRepository repository){
        return new CreateCourseUseCase(repository);
    }

    @Bean
    public UpdateCourseUseCase updateCourseUseCase(CourseRepository repository){
        return new UpdateCourseUseCase(repository);
    }

    @Bean
    public GetCourseUseCase getCourseUseCase(CourseRepository repository){
        return new GetCourseUseCase(repository);
    }

    @Bean
    public ListCourseUseCase listCourseUseCase(CourseRepository repository){
        return new ListCourseUseCase(repository);
    }

    @Bean
    public DeleteCourseUseCase deleteCourseUseCase(CourseRepository repository){
        return new DeleteCourseUseCase(repository);
    }
}
