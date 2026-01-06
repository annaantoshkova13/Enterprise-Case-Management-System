package org.example.enterprisecasemanagementsystem;


import org.example.enterprisecasemanagementsystem.teacher.Teacher;
import org.example.enterprisecasemanagementsystem.user.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    public void shouldChangeDepartment_WhenValid() {
        User user = new User();
        Teacher teacher = new Teacher("Jon", "Jonson", "QA", user);
        teacher.changeDepartment("Java");
        assertEquals("Java", teacher.getDepartment());
    }

    @Test
    public void shouldFail_WhenDepartmentIsNull() {
        User user = new User();
        Teacher teacher = new Teacher("Jon", "Jonson", "QA", user);
        IllegalArgumentException ex =  assertThrows(IllegalArgumentException.class,
                () -> teacher.changeDepartment(null),
                "Department cannot be empty");
        assertEquals("Department cannot be empty", ex.getMessage());
    }

    @Test
    public void shouldFail_WhenDepartmentIsBlank() {
        User user = new User();
        Teacher teacher = new Teacher("Jon", "Jonson", "QA", user);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> teacher.changeDepartment("  "),
                "Department cannot be empty");
        assertEquals("Department cannot be empty", ex.getMessage());
    }
}
