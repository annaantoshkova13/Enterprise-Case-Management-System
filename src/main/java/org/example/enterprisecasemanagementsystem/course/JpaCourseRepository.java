package org.example.enterprisecasemanagementsystem.course;

import org.example.enterprisecasemanagementsystem.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCourseRepository extends JpaRepository<User, Long> {

}
