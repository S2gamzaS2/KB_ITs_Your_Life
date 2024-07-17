USE sqldb;

# 1번
CREATE TABLE tbl1 (
	a INT PRIMARY KEY,
    B INT,
    C INT
);
-- 자동 생성된 인덱스 목록 확인
SHOW INDEX FROM tbl1;

# 2번
CREATE TABLE tbl2 (
	a INT PRIMARY KEY,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);
-- 자동 생성된 인덱스 목록 확인
SHOW INDEX FROM tbl2;

# 3번
CREATE TABLE tbl3 (
	a INT UNIQUE,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);
-- 자동 생성된 인덱스 목록 확인
SHOW INDEX FROM tbl3;

# 4번
CREATE TABLE tbl4 (
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT
);
-- 자동 생성된 인덱스 목록 확인
SHOW INDEX FROM tbl4;

# 5번
CREATE TABLE tbl5 (
	a INT UNIQUE NOT NULL,
    b INT UNIQUE,
    c INT UNIQUE,
    d INT PRIMARY KEY
);
SHOW INDEX FROM tbl5;

# 6번
-- testdb 데이터베이스에 usertbl 테이블 만들기
CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl (
 userID CHAR(8) NOT NULL PRIMARY KEY,
 name VARCHAR(10) NOT NULL,
 birthYear INT NOT NULL,
 addr CHAR(2) NOT NULL
);
-- 데이터 추가
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울');  
-- 클러스터형 인덱스 테이블 내용 확인
SELECT * FROM usertbl;
SHOW INDEX FROM usertbl;

# 7번
-- PRIMARY KEY 제약조건 제거
ALTER TABLE usertbl DROP PRIMARY KEY;
-- name 컬럼에 pk_name이라는 제약조건으로 기본키 설정
ALTER TABLE usertbl
ADD CONSTRAINT pk_name PRIMARY KEY (name);
-- usertbl 내용 출력, 새로운 클러스터형 인덱스 확인
SELECT * FROM usertbl;
SHOW INDEX FROM usertbl;