package org.example.enterprisecasemanagementsystem.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStudentRepository extends  StudentRepository,JpaRepository<Student,Long> {
}
