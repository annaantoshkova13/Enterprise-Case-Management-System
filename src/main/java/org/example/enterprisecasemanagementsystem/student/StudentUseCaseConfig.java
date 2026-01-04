package org.example.enterprisecasemanagementsystem.student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentUseCaseConfig {
    @Bean
    public CreateStudentUseCase createStudentUseCase(StudentRepository repository){
        return new CreateStudentUseCase(repository);
    }

    @Bean
    public UpdateStudentGroupUseCase updateStudentGroupUseCase(StudentRepository repository){
        return new UpdateStudentGroupUseCase(repository);
    }

    @Bean
    public DeleteStudentUseCase deleteStudentUseCase(StudentRepository repository){
        return new DeleteStudentUseCase(repository);
    }

    @Bean
    public GetStudentByIdUseCase getStudentByIdUseCase(StudentRepository repository){
        return new GetStudentByIdUseCase(repository);
    }

    @Bean
    public ListStudentsUseCase listStudentsUseCase(StudentRepository repository){
        return new ListStudentsUseCase(repository);
    }
}
