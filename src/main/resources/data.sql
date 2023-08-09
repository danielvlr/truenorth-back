-- src/main/resources/data.sql

-- Insert mock users
INSERT INTO users (username, password, status)
VALUES
    ('user1@example.com', 'password1', 'active'),
    ('user2@example.com', 'password2', 'active');

-- Insert mock operations
INSERT INTO operations (type, cost)
VALUES
    ('addition', 1.0),
    ('subtraction', 1.0),
    ('multiplication', 2.0),
    ('division', 2.0),
    ('square_root', 3.0),
    ('random_string', 0.5);