-- Version: 3
-- Description: Create Record table

CREATE TABLE records (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    operation_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    amount DOUBLE NOT NULL,
    user_balance DOUBLE NOT NULL,
    operation_response DOUBLE NOT NULL,
    date TIMESTAMP NOT NULL,
    deleted BOOLEAN NOT NULL,
    FOREIGN KEY (operation_id) REFERENCES operations(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);