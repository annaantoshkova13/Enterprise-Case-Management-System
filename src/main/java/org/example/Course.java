package org.example;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherProfile teacherProfile;

    public Course() {
    }

    public Course(Long id, String title, String description, LocalDateTime createdDate, TeacherProfile teacherProfile) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.teacherProfile = teacherProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public TeacherProfile getTeacherProfile() {
        return teacherProfile;
    }

    public void setTeacherProfile(TeacherProfile teacherProfile) {
        this.teacherProfile = teacherProfile;
    }
}
