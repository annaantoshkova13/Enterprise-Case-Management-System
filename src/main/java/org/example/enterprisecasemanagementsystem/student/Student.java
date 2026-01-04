package org.example.enterprisecasemanagementsystem.student;

import jakarta.persistence.*;
import org.apache.catalina.Group;
import org.example.enterprisecasemanagementsystem.profile.Profile;
import org.example.enterprisecasemanagementsystem.user.User;

@Entity
public class Student extends Profile {

    private String group;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Student() {
    }

    public Student(User user, Group group) {
    }

    public Student(User user) {
        this.user = user;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void changeGroup(String newGroup) {
        if (newGroup == null || newGroup.isBlank()) {
            throw new IllegalArgumentException("Group cannot be empty");
        }
        this.group = newGroup;
    }
}
