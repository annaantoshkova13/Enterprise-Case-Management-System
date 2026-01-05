create table students(
    id BIGINT PRIMARY KEY,
    group_name VARCHAR(100),
    CONSTRAINT fk_students_profile FOREIGN KEY (id) REFERENCES profiles(id) ON DELETE CASCADE
);