-- src/main/resources/data.sql

-- Insert mock users
INSERT INTO users (username, password, status)
VALUES
    ('user1@example.com', '$2a$10$cWi415.nHanoKn4C9dQGeOvF.K5mgTmZJNXqNkdkw1kgeNddEbxiu', 'ACTIVE'),
    ('user2@example.com', '$2a$10$cWi415.nHanoKn4C9dQGeOvF.K5mgTmZJNXqNkdkw1kgeNddEbxiu', 'ACTIVE');

-- Insert mock operations
INSERT INTO operations (type, cost)
VALUES
    ('ADDITION', 1.0),
    ('SUBTRACTION', 1.0),
    ('MULTIPLICATION', 2.0),
    ('DIVISION', 2.0),
    ('SQUARE_ROOT', 3.0),
    ('RANDOM_STRING', 0.5);


INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
INSERT INTO records(operation_id, user_id, amount, user_balance, operation_response, `date`, deleted) VALUES(1, 1, 1, 1, 1, now(), 1);
