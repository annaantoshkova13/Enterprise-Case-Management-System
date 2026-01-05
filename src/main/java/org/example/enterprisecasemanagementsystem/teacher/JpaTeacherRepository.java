package org.example.enterprisecasemanagementsystem.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTeacherRepository extends TeacherRepository,JpaRepository<Teacher, Long> {
}
