create table profiles(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    user_id BIGINT UNIQUE,
    CONSTRAINT fk_profiles_user FOREIGN KEY (user_id) REFERENCES users(id)
);