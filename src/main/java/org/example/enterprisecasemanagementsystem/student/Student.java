package org.example.enterprisecasemanagementsystem.student;

import jakarta.persistence.*;
import org.apache.catalina.Group;
import org.example.enterprisecasemanagementsystem.profile.Profile;
import org.example.enterprisecasemanagementsystem.user.User;

@Entity
public class Student extends Profile {

    private String groupName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Student() {
    }

    public Student(User user, Group groupName) {
    }

    public Student(User user) {
        this.user = user;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
        this.groupName = newGroup;
    }
}
