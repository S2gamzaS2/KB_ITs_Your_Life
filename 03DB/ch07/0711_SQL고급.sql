# 데이터 형변환 (CAST/CONVERT)
USE sqldb;
SELECT AVG(amount) AS '평균 구매 개수' FROM buytbl; -- 2.9167
SELECT CAST(AVG(amount) AS SIGNED INTEGER) AS '평균 구매 개수' FROM buytbl; -- 3
SELECT CONVERT(AVG(amount), SIGNED INTEGER) AS '평군 구매 개수' FROM buytbl; -- 3

## 내장함수
# IF(수식, 참, 거짓)
SELECT IF (100 > 200, '참', '거짓');

# IFNULL(수식1, 수식2)
SELECT IFNULL(NULL, '널이다'); -- 널이다
SELECT IFNULL(100, '널이다'); -- 100

# CONCAT / CONCAT_WS
SELECT CONCAT('이거랑', '이거 합쳐');
SELECT CONCAT_wS('*', '이거랑', '이거 합쳐');

# REPLACE(문자열, 원래, 바꿀)
SELECT REPLACE('이것이 MY SQL이다', '이것이', '저것이');

# SUBSTRING(문자열, 시작위치, 길이)
SELECT SUBSTRING('대한민국만세', 3, 2);

# CEILING, FLOOR, ROUND
SELECT CEILING(4.7), FLOOR(4.7), ROUND(4.7);

# 날짜 / 시간
SELECT CURDATE(); -- 날짜
SELECT CURTIME(); -- 시간
SELECT NOW(); -- 날짜 + 시간
SELECT SYSDATE(); -- 날짜 + 시간


USE employees;
SELECT * FROM dept_emp; -- 직원 - 부서 / 기간 테이블
-- 9999-01-01 : 현재
-- to_date가 9999-01-01이 아니라면 현재 재직X
SELECT COUNT(*) AS '재직 중' FROM dept_emp 
WHERE to_date = '9999/01/01'; -- 현재 재직중인 직원 수

