create table teachers(
    id BIGINT PRIMARY KEY,
    department VARCHAR(100),
    CONSTRAINT fk_teachers_profile FOREIGN KEY (id) REFERENCES profiles(id) ON DELETE CASCADE
);