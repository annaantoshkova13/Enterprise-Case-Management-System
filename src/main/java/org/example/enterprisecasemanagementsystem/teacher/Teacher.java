package org.example.enterprisecasemanagementsystem.teacher;

import jakarta.persistence.*;
import org.example.enterprisecasemanagementsystem.profile.Profile;
import org.example.enterprisecasemanagementsystem.user.User;

@Entity
public class Teacher extends Profile {

    private String department;

    public Teacher() {
    }

    public Teacher(Long id, String firstName, String lastName, String department) {
        super(id, firstName, lastName);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void changeDepartment(String newDepartment) {
        if (newDepartment == null || newDepartment.isBlank()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.department = newDepartment;
    }
}
