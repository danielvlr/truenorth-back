-- Version: 2
-- Description: Create Operation table

CREATE TABLE operations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50) NOT NULL UNIQUE,
    cost DOUBLE NOT NULL
);