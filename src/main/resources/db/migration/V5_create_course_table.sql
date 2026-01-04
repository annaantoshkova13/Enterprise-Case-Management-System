create table course(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    teacher_id BIGINT NOT NULL,
    CONSTRAINT fk_teacher
        FOREIGN KEY(teacher_id)
        REFERENCES teachers(id)
        ON DELETE CASCADE
);