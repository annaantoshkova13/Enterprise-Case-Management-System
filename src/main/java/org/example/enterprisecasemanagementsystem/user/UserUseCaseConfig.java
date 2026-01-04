package org.example.enterprisecasemanagementsystem.user;

import org.example.enterprisecasemanagementsystem.course.CourseRepository;
import org.example.enterprisecasemanagementsystem.course.GetCourseUseCase;
import org.example.enterprisecasemanagementsystem.course.ListCourseUseCase;
import org.example.enterprisecasemanagementsystem.course.UpdateCourseUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository repository){
        return new CreateUserUseCase(repository);
    }

    @Bean
    public UpdateCourseUseCase updateUserUseCase(CourseRepository repository){
        return new UpdateCourseUseCase(repository);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(UserRepository repository){
        return new DeleteUserUseCase(repository);
    }

    @Bean
    public ListCourseUseCase listUserUseCase(CourseRepository repository){
        return new ListCourseUseCase(repository);
    }

    @Bean
    public GetCourseUseCase getUserUseCase(CourseRepository repository){
        return new GetCourseUseCase(repository);
    }
}
