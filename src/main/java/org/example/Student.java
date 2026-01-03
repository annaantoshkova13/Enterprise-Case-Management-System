package org.example;

import jakarta.persistence.*;

@Entity
public class Student extends Profile {

    private String group;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Student() {
    }

    public Student(Long id, User user) {
        this.group = group;
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
}
