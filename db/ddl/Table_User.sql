USE la_foresta;

CREATE TABLE user (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('ACTIVE', 'BLOCKED', 'INACTIVE')),
    user_type VARCHAR(30) NOT NULL CHECK (user_type IN ('INVESTOR', 'BROKER', 'ADMIN', 'LEGAL', 'BOARD')),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);