package org.example.enterprisecasemanagementsystem.course;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends CourseRepository, JpaRepository<Course, Long> {

}
