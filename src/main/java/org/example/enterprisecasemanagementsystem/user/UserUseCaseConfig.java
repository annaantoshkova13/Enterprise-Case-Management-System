package org.example.enterprisecasemanagementsystem.user;

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
        return new UpdateUserProfileUseCase(repository); // УБРАТЬ каст (UserRepository)
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(UserRepository repository){
        return new DeleteUserUseCase(repository);
    }

    @Bean
    public ListUsersUseCase listUserUseCase(UserRepository repository){
        return new ListUsersUseCase(repository); // УБРАТЬ каст (UserRepository)
    }

    @Bean
    public GetUserByIdUseCase getUserUseCase(UserRepository repository){
        return new GetUserByIdUseCase(repository); // УБРАТЬ каст (UserRepository)
    }

    @Bean
    public ChangeUserRoleUseCase changeUserRoleUseCase(UserRepository repository){
        return new ChangeUserRoleUseCase(repository);
    }
}
