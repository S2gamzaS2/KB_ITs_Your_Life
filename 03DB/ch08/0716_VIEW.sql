USE sqldb;

# 기본 뷰 생성
CREATE VIEW v_userbuytbl
AS
SELECT U.userId AS 'USER ID', U.name AS 'USER NAME', B.prodName AS 'PRODUCT NAME',
U.addr AS 'USER ADDRESS', CONCAT(U.mobile1, U.mobile2) AS 'MOBILE PHONE'
FROM usertbl U
INNER JOIN buytbl B
ON U.userId = B.userId;

# v_userbuytbl 뷰 보기
SELECT * FROM v_userbuytbl;

# 뷰 수정
ALTER VIEW v_userbuytbl
AS
SELECT U.userId AS '아이디', U.name AS '이름', B.prodName AS '제품 이름',
U.addr AS '주소', CONCAT(U.mobile1, U.mobile2) AS '핸드폰'
FROM usertbl U
INNER JOIN buytbl B
ON U.userId = B.userId;
SELECT * FROM v_userbuytbl;

# 뷰 삭제
DROP VIEW v_userbuytbl;

-- --------------------

# 기존에 있는 뷰 덮어쓰기
CREATE OR REPLACE VIEW v_usertbl
AS
SELECT userId, name, addr FROM usertbl;
DESC v_usertbl;

# 뷰를 통해 데이터 수정
UPDATE v_usertbl SET addr = '부산' WHERE userId = 'JKW';
SELECT * FROM v_usertbl; 
SELECT * FROM usertbl; -- 조관우 주소 부산으로 바뀜

# 뷰 데이터 입력
DESC usertbl; -- 이름, 출생년도, 주소 -> NOT NULL
INSERT INTO v_usertbl (userId, name, addr) VALUES ('KBM', '김병만', '충북'); -- 출생년도 없어서 에러
INSERT INTO v_usertbl (userId, name, addr, birthYear) VALUES ('KBM', '김병만', '충북', '1996'); -- VIEW에 출생년도가 없어서 에러
## 출생년도가 포함된 뷰 다시 생성
CREATE OR REPLACE VIEW v_usertbl
AS
SELECT userId, name, addr, birthYear FROM usertbl;
INSERT INTO v_usertbl (userId, name, addr, birthYear) VALUES ('KBM', '김병만', '충북', '1996');

SELECT * FROM usertbl; -- 김병만 데이터 추가 됨

-- ----------------------

# SUM() 함수를 사용하는 뷰 정의 - INSERT 안됨 => 집계함수를 사용한 뷰 수정x
CREATE OR REPLACE VIEW v_sum
AS
SELECT num, userId, prodName, price, amount, SUM(price * amount)
FROM buytbl
GROUP BY num;
SELECT * FROM v_sum;
INSERT INTO v_sum (num, userId, prodName, price, amount) VALUES ('13', 'HJK', '노트북', 300, 10);

-- ------------------------

# 지정한 범위로 뷰 생성, 데이터 입력
CREATE OR REPLACE VIEW v_height177
AS
SELECT * FROM usertbl
WHERE height >= 177;

# v_height177에서 키가 177이하인 데이터 삭제 (없음)
DELETE FROM v_height177
WHERE height < 177;
SELECT * FROM usertbl; -- 기존 테이블에 반영 안됨 왜?

# v_height177에 177미만인 데이터 입력
INSERT INTO v_height177 VALUES ('PMS', '박명수', 1977, '경기', '010', '55555555', 158, '2023-01-01');
SELECT * FROM v_height177; -- 뷰에는 안보이지만 기존 usertbl에는 추가됨

# v_height177 뷰에는 키가 177이상인 데이터만 입력 받아야함
## WITH CHECK OPTION
ALTER VIEW v_height177
AS
SELECT * FROM usertbl
WHERE height >= 177
WITH CHECK OPTION;
INSERT INTO v_height177 VALUES ('SJH', '서장훈', 2006, '서울', '010', '88888888', 155, '2023-03-03'); -- 에러

-- ------------------------

# 두 개 이상의 테이블이 관련되는 복합 뷰 생성, 데이터 입력
## 두 개 이상의 테이블이 관련된 뷰는 업데이트 X
CREATE VIEW v_userbuytbl
AS
SELECT U.userId AS 'USER ID', U.name AS 'USER NAME', B.prodName AS 'PRODUCT NAME',
U.addr AS 'USER ADDRESS', CONCAT(U.mobile1, U.mobile2) AS 'MOBILE PHONE'
FROM usertbl U
INNER JOIN buytbl B
ON U.userId = B.userId;

INSERT INTO
