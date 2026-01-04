package org.example.enterprisecasemanagementsystem.user;

import jakarta.persistence.*;
import org.example.enterprisecasemanagementsystem.Role;
import org.example.enterprisecasemanagementsystem.student.Student;
import org.example.enterprisecasemanagementsystem.teacher.Teacher;

import java.time.LocalDateTime;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column (unique = true, nullable = false)
    private String email;

    @Column (nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private Role role;

    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Teacher teacher;

    public User(Long id, String email, String passwordHash, Role role, LocalDateTime createdAt, Student student, Teacher teacher) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.createdAt = createdAt;
        this.student = student;
        this.teacher = teacher;
    }

    public User() {
    }

    public User(Object o, String email, String passwordHash, Role role, Object object) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
