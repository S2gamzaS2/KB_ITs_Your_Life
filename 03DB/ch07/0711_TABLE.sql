# 데이터베이스 생성
CREATE DATABASE tabledb;

USE tabledb;

# usertbl 테이블 생성
CREATE TABLE usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL,
    addr CHAR(2) NOT NULL,
    mobile1 CHAR(3) NULL,
    mobile2 CHAR(8) NULL,
    height SMALLINT NULL,
    mDate DATE NULL
);

#buytbl 테이블 생성
CREATE TABLE buytbl(
	num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    userid CHAR(8) NOT NULL,
    prodName CHAR(6) NOT NULL,
    groupName CHAR(4) NULL,
    price INT NOT NULL,
    amount SMALLINT NOT NULL,
    FOREIGN KEY(userid) REFERENCES usertbl(userID)
);

# 데이터 입력
INSERT INTO usertbl VALUES ('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8'),
('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-4-4'),
('KKH', '김경호', 1971, '전남', '019', '33333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES ('JYP', '조용필', '1950', '인천', '010', '44444444', 170, '2000-10-12');
INSERT INTO buytbl VALUES (NULL, 'KBS', '운동화', NULL, 30, 2), (NULL, 'KBS', '노트북', '전자', 1000, 1), (NULL, 'JYP', '모니터', '전자', 200, 1);

SELECT * FROM usertbl;
SELECT * FROM buytbl;
DESCRIBE usertbl;

-- -----------------------
## 제약조건

CREATE TABLE userTBL2 (
	userID CHAR(8) NOT NULL,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL,
    CONSTRAINT PRIMARY KEY PK_userTBL_userID (userID)
);
DESCRIBE USERTBL2;

CREATE TABLE userTBL3 (
	userID CHAR(8) NOT NULL,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL
);
DESCRIBE userTBL3; -- PK 없음
ALTER TABLE userTBL3
	ADD CONSTRAINT PK_userTBL_userID -- PK_userTBL_userID: 제약 조건 이름 
		PRIMARY KEY (userID);
DESCRIBE userTBL3; -- PK 생김

-- 복합키
CREATE TABLE prodTBL2 (
	prodCode CHAR(3) NOT NULL,
    prodID CHAR(4) NOT NULL,
    prodDate DATETIME NOT NULL,
    prodCur CHAR(10) NULL
);
DESCRIBE prodTBL2;
ALTER TABLE prodTBL2
	ADD CONSTRAINT PK_prodTBL_proCodE_prodID
		PRIMARY KEY (prodCode, prodID);
DESCRIBE prodTBL2;
SHOW INDEX FROM prodTBL2;
    