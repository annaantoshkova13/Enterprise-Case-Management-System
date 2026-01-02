package org.example.enterprisecasemanagementsystem;

import jakarta.persistence.*;

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
    private StudentPtofile studentPtofile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private TeacherProfile teacherProfile;

    public User(Long id, String email, String passwordHash, Role role, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.createdAt = createdAt;
    }

    public User() {
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
