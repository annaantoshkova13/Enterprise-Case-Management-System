package org.example.enterprisecasemanagementsystem;

import jakarta.persistence.*;

@Entity
public class Teacher extends Profile {

    private String department;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Teacher() {
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
}
