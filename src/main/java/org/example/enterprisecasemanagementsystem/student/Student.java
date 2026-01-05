package org.example.enterprisecasemanagementsystem.student;

import jakarta.persistence.*;
import org.apache.catalina.Group;
import org.example.enterprisecasemanagementsystem.profile.Profile;
import org.example.enterprisecasemanagementsystem.user.User;

@Entity
public class Student extends Profile {

    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public void changeGroup(String newGroup) {
        if (newGroup == null || newGroup.isBlank()) {
            throw new IllegalArgumentException("Group cannot be empty");
        }
        this.groupName = newGroup;
    }
}
