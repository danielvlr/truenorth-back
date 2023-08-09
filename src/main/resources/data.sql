-- src/main/resources/data.sql

-- Insert mock users
INSERT INTO users (username, password, status)
VALUES
    ('user1@example.com', '$2a$10$cWi415.nHanoKn4C9dQGeOvF.K5mgTmZJNXqNkdkw1kgeNddEbxiu', 'ACTIVE'),
    ('user2@example.com', '$2a$10$cWi415.nHanoKn4C9dQGeOvF.K5mgTmZJNXqNkdkw1kgeNddEbxiu', 'ACTIVE');

-- Insert mock operations
INSERT INTO operations (type, cost)
VALUES
    ('addition', 1.0),
    ('subtraction', 1.0),
    ('multiplication', 2.0),
    ('division', 2.0),
    ('square_root', 3.0),
    ('random_string', 0.5);