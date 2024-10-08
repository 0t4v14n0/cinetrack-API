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
    year INT,
    data VARCHAR(255),
    note DOUBLE,
    gender VARCHAR(50),
    director VARCHAR(255),
    actor VARCHAR(255),
    synopsis TEXT,
    poster VARCHAR(255),
    INDEX idx_movie_title (title),
    INDEX idx_movie_gender (gender)
);

CREATE TABLE serie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    year VARCHAR(255),
    plot TEXT,
    total_season INT,
    episode_number INT,
    release_date VARCHAR(255),
    gender VARCHAR(50),
    rating DOUBLE,
    votes INT,
    runtime INT,
    poster VARCHAR(255),
    INDEX idx_serie_title (title),
    INDEX idx_serie_gender (gender)
);

CREATE TABLE season (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    season_number INT NOT NULL,
    total_season INT NOT NULL,
    serie_id BIGINT NOT NULL,
    FOREIGN KEY (serie_id) REFERENCES serie(id) ON DELETE CASCADE
);

CREATE TABLE episode (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    plot TEXT,
    episode_number INT NOT NULL,
    release_date VARCHAR(50),
    rating DOUBLE,
    votes INT,
    runtime INT,
    season_id BIGINT NOT NULL,
    FOREIGN KEY (season_id) REFERENCES season(id) ON DELETE CASCADE
);

CREATE TABLE review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    movie_id BIGINT,
    serie_id BIGINT,
    season_id BIGINT,
    episode_id BIGINT,
    rating DOUBLE,
    review_text TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (movie_id) REFERENCES movie(id),
    FOREIGN KEY (serie_id) REFERENCES serie(id),
    FOREIGN KEY (episode_id) REFERENCES episode(id),
    INDEX idx_review_user (user_id)
);

CREATE TABLE review_likes (
    user_id BIGINT,
    review_id BIGINT,
    PRIMARY KEY (user_id, review_id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (review_id) REFERENCES review(id),
    INDEX idx_review_likes_user (user_id),
    INDEX idx_review_likes_review (review_id)
);

CREATE TABLE favorite (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    serie_id BIGINT,
    movie_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (serie_id) REFERENCES serie(id),
    FOREIGN KEY (movie_id) REFERENCES movie(id)
);

CREATE TABLE friends (
    user1_id BIGINT NOT NULL,
    user2_id BIGINT NOT NULL,
    status ENUM('INVITED', 'RECUSED','ACCEPTED', 'BLOCKED'),
    last_status BIGINT,
    invited_at DATETIME,
    status_at DATETIME,
    PRIMARY KEY (user1_id, user2_id),
    FOREIGN KEY (user1_id) REFERENCES user(id),
    FOREIGN KEY (user2_id) REFERENCES user(id)
);

CREATE TABLE chat (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user1_id BIGINT NOT NULL,
    user2_id BIGINT NOT NULL,
    created_at DATETIME,
    FOREIGN KEY (user1_id) REFERENCES user(id),
    FOREIGN KEY (user2_id) REFERENCES user(id)
);

CREATE TABLE message (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sender_id BIGINT NOT NULL,
    chat_id BIGINT NOT NULL,
    content TEXT,
    timestamp DATETIME,
    FOREIGN KEY (sender_id) REFERENCES user(id),
    FOREIGN KEY (chat_id) REFERENCES chat(id)
);
