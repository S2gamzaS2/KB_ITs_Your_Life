USE sqldb;

# WHERE절
SELECT * FROM usertbl WHERE name = '김경호';
SELECT userID, name FROM usertbl WHERE birthYear >= 1970 AND height >= 182;
SELECT userid, name FROM usertbl WHERE birthYear >= 1970 OR height >= 182;

# BETWEEN ~ AND
SELECT name, height FROM usertbl WHERE height BETWEEN  180 AND 183;
SELECT name, addr FROM usertbl WHERE addr = '경남' OR addr = '경북';

# IN() : 이산적인 값
SELECT name, addr FROM usertbl WHERE addr IN ('경남', '경북', '전남');

# LIKE : 문자열 검색 (부분 일치)
SELECT name, height FROM usertbl WHERE name LIKE '김%';
SELECT name, height FROM usertbl WHERE name LIKE '_용%';

# 서브쿼리
SELECT name, height FROM usertbl
WHERE height > (SELECT height FROM usertbl WHERE name = '김경호'); -- 김경호(177)의 키보다 큰 사람의 이름과 키

# ANY (OR)
-- 경남 사람들보다 키가 크 사람
SELECT name, height FROM usertbl
WHERE addr = '경남'; -- 김범수(173) / 윤종신(170)
SELECT name, height FROM usertbl
WHERE height = ANY (SELECT height FROM usertbl WHERE addr = '경남'); -- 키가 173이거나 170인 사람
SELECT name, height FROM usertbl
WHERE height IN (SELECT height FROM usertbl WHERE addr = '경남'); -- ANY = IN

# ALL (AND)
SELECT name, height FROM usertbl
WHERE height > ALL (SELECT height FROM usertbl WHERE addr = '경남'); -- 173보다도 커야하고 170보다도 커야함


# ORDER BY 
SELECT name, height FROM usertbl
ORDER BY height; -- 키로 분류..~
SELECT name, height FROM usertbl
ORDER BY height DESC, name;

USE world;
-- countrycode가 KOR 중, population기준으로 내림차순 정렬
SELECT * FROM city
WHERE countrycode = 'kor'
ORDER BY population DESC;
-- 우리나라에서 제주의 인구수보다 작은 도시를 찾아 인구수를 내림차순으로 출력
SELECT name, population FROM city
WHERE countrycode = 'kor' AND population < (SELECT population FROM city WHERE name = "cheju")
ORDER BY population DESC;

# DISTINCT
SELECT DISTINCT addr FROM usertbl;

# CREATE TABLE
USE employees;
CREATE TABLE users
(SELECT first_name as name, gender FROM employees);
SELECT * FROM users; -- 복사됐음

USE world;
SELECT * FROM city
WHERE countrycode = 'kor';
CREATE TABLE kor_city
(SELECT id, name, district, population FROM city
WHERE countrycode = 'kor'
ORDER BY name);
SELECT * FROM kor_city;

# GROUP BY
-- 국가별 총 인구수
SELECT countrycode as '나라 이름', SUM(population) as '인구수' FROM city
GROUP BY countrycode
HAVING 인구수 > 10000000
ORDER BY 인구수 DESC;

USE sqldb;
SELECT userID, SUM(amount) as '총 구매 개수' FROM buytbl
GROUP BY userID;

SELECT userID as '사용자 아이디', SUM(price * amount) as '총 구매액'
FROM buytbl GROUP BY userID;

SELECT COUNT(mobile1) as '휴대폰이 있는 사용자' FROM usertbl;

# HAVING
USE sqldb;
SELECT userID as '사용자', SUM(price * amount) as '총구매액'
FROM buytbl
GROUP BY userID
HAVING 총구매액 > 1000
ORDER BY SUM(price * amount);

# WITH ROLLUP
USE sqldb;
SELECT groupName, SUM(price*amount) as '비용'
FROM buytbl
GROUP BY groupName
WITH ROLLUP; 

# INSERT
USE sqldb;
CREATE TABLE testTbl1 (id int, userName char(3), age int); -- 임시 테이블 생성
INSERT INTO testTbl1 (id, userName) VALUES (2, '설현');
SELECT * FROM testTbl1;

# AUTO_INCREMENT
CREATE TABLE testTbl2
	(id int AUTO_INCREMENT PRIMARY KEY,
    userName char(3),
    age int); -- 임시 테이블 생성
INSERT INTO testTbl2 VALUES (NULL, '지민', 25); -- 1
INSERT INTO testTbl2 VALUES (NULL, '유나', 22); -- 2
INSERT INTO testTbl2 VALUES (NULL, '유경', 21); -- 3
ALTER TABLE testTbl2 AUTO_INCREMENT = 100; -- 입력값을 100부터
INSERT INTO testTbl2 VALUES (NULL, '찬미', 23); -- 100
SET @@auto_increment_increment = 3; -- 증가값 3
INSERT INTO testTbl2 VALUES(NULL, '나연', 20); -- 103
SELECT * FROM testTbl2;

# UPDATE
SET SQL_SAFE_UPDATES = 0; -- 안전 업데이트 모드를 일시적으로 비활성화
UPDATE testTbl2
SET userName = '감자'
WHERE age = 22;
SELECT * FROM testTbl2;
SET SQL_SAFE_UPDATES = 1; -- 안전 업데이트 모드 활성화

