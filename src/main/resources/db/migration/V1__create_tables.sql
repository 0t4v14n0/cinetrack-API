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
    last_login TIMESTAMP,
    INDEX idx_user_status (status)
);

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
    FOREIGN KEY (user_id) REFERENCES user(id),
    INDEX idx_movie_title (title),
    INDEX idx_movie_gender (gender)
);

CREATE TABLE serie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    plot TEXT,
    total_season INT,
    episode_number INT,
    release_date DATE,
    gender ENUM('ACTION', 'COMEDY', 'DRAMA', 'FANTASY', 'HORROR', 'MYSTERY', 'ROMANCE', 'THRILLER'),
    rating DOUBLE,
    votes INT,
    runtime INT,
    poster VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id),
    INDEX idx_serie_title (title),
    INDEX idx_serie_gender (gender)
);

CREATE TABLE season (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    serie_id BIGINT,
    season_number INT,
    total_episodes INT,
    release_date DATE,
    FOREIGN KEY (serie_id) REFERENCES serie(id),
    INDEX idx_season_serie (serie_id)
);

CREATE TABLE episode (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    season_id BIGINT,
    title VARCHAR(255),
    plot TEXT,
    episode_number INT,
    release_date DATE,
    rating DOUBLE,
    votes INT,
    runtime INT,
    FOREIGN KEY (season_id) REFERENCES season(id),
    INDEX idx_episode_season (season_id),
    INDEX idx_episode_title (title)
);

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
    FOREIGN KEY (episode_id) REFERENCES episode(id),
    INDEX idx_review_user (user_id)
);