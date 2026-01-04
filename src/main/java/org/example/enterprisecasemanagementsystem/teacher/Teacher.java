package org.example.enterprisecasemanagementsystem.teacher;

import jakarta.persistence.*;
import org.example.enterprisecasemanagementsystem.profile.Profile;
import org.example.enterprisecasemanagementsystem.user.User;

@Entity
public class Teacher extends Profile {

    private String department;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Teacher() {
    }

    public Teacher(User user, String department) {
    }

    public Teacher(Long id, User user) {
        this.department = department;
        this.user = user;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void changeDepartment(String newDepartment) {
        if (newDepartment == null || newDepartment.isBlank()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.department = newDepartment;
    }
}
