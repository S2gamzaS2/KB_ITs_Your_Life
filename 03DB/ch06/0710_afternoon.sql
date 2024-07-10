-- 0710 오후 수업

# DB 생성 - 백틱(``) + 소문자
CREATE SCHEMA `mydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE mydb;

# 테이블 생성
CREATE TABLE user (
	`id_pk` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, -- NULL(x) & PK
    `name` VARCHAR(10) NOT NULL, -- NULL(x)
    `user_id` VARCHAR(10) NOT NULL UNIQUE, -- NULL(x), 중복(x)
    `password` VARCHAR(10) NOT NULL,
    `age` TINYINT UNSIGNED, -- UNSIGNED(양수)
    `membership` TINYINT DEFAULT 0, -- 기본값이 0
    `register_date` DATETIME DEFAULT CURRENT_TIMESTAMP, -- 날짜, 기본값 현재날짜auto_increment`
    `update_date` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- UPDATE가 될 때 CURRENT_TIMESTAMP 발동(ON)
);

# 데이터 추가
INSERT INTO user (name, user_id, password, age) VALUES ('왕감자', 'gamzaS2', '0828', 8);
INSERT INTO user (name, user_id, password, age) VALUES ('왕감자2', 'gamzaS22', '0828', 8);
INSERT INTO user (name, user_id, password, age) VALUES ('왕감자2', 'gamzaS23', '0828', 8);

# 데이터 삭제
DELETE FROM user WHERE id_pk = 4;

# 데이터 수정
INSERT INTO user (name, user_id, password, age) VALUES ('왕감자2', 'gamzaS24', '0828', 8); -- 데이터 추가
UPDATE user SET age = age + 1
WHERE id_pk = 5 ;
