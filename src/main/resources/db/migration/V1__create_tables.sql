-- Tabela user
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    status ENUM('active', 'disabled') DEFAULT 'active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    role ENUM('admin', 'user') DEFAULT 'user',
    avatar_url VARCHAR(255),
    phone_number VARCHAR(20),
    bio TEXT,
    last_login TIMESTAMP
);

-- Tabela movie
CREATE TABLE movie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    year YEAR,
    data DATE,
    note DOUBLE,
    gender ENUM('ACTION', 'COMEDY', 'DRAMA', 'FANTASY', 'HORROR', 'MYSTERY', 'ROMANCE', 'THRILLER'),
    director VARCHAR(255),
    actor VARCHAR(255),
    synopsis TEXT,
    poster VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Tabela serie
CREATE TABLE serie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    plot TEXT,
    total_season INT,
    episode_number INT,
    release_date DATE,
    rating DOUBLE,
    votes INT,
    runtime INT,
    poster VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Tabela episode
CREATE TABLE episode (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    plot TEXT,
    episode_number INT,
    season_number INT,
    release_date DATE,
    rating DOUBLE,
    votes INT,
    runtime INT,
    serie_id BIGINT,
    FOREIGN KEY (serie_id) REFERENCES serie(id)
);

-- Tabela review
CREATE TABLE review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    movie_id BIGINT,
    serie_id BIGINT,
    episode_id BIGINT,
    rating DOUBLE,
    review_text TEXT,
    created_at DATETIME,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (movie_id) REFERENCES movie(id),
    FOREIGN KEY (serie_id) REFERENCES serie(id),
    FOREIGN KEY (episode_id) REFERENCES episode(id)
);