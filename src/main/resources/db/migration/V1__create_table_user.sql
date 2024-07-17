CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    status ENUM('active', 'disabled') NOT NULL DEFAULT 'active',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    role ENUM('admin', 'user') NOT NULL DEFAULT 'user',
    avatar_url VARCHAR(255),
    phone_number VARCHAR(20),
    bio TEXT,
    last_login TIMESTAMP
);