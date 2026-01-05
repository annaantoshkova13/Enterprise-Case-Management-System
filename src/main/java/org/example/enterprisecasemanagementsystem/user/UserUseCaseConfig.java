package org.example.enterprisecasemanagementsystem.user;

import org.example.enterprisecasemanagementsystem.course.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository repository){
        return new CreateUserUseCase(repository);
    }

    @Bean
    public UpdateUserProfileUseCase updateUserUseCase(UserRepository repository){
        return new UpdateUserProfileUseCase((UserRepository) repository);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(UserRepository repository){
        return new DeleteUserUseCase(repository);
    }

    @Bean
    public ListUsersUseCase listUserUseCase(UserRepository repository){
        return new ListUsersUseCase((UserRepository) repository);
    }

    @Bean
    public GetUserByIdUseCase getUserUseCase(UserRepository repository){
        return new GetUserByIdUseCase((UserRepository) repository);
    }
}
