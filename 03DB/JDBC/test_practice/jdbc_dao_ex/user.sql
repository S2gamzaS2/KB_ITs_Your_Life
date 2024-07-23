SELECT * FROM users;

# user_info 테이블 생성
DROP TABLE IF EXISTS users_info;
CREATE TABLE users_info (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,

    FOREIGN KEY (id) REFERENCES users (id) ON DELETE CASCADE
);

INSERT INTO users_info (id, name) VALUES (1, '이효석'), (2, '김시완'), (3, '나건우');

SELECT * FROM users_info;
