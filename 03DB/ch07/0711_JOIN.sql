##INNER JOIN
USE sqldb;
SELECT * FROM buytbl
INNER JOIN usertbl
ON buytbl.userID = usertbl.userID
WHERE buytbl.userID = 'JYP';

SELECT * FROM buytbl b
INNER JOIN usertbl u
ON b.userID = u.userID
ORDER BY b.userID;

SELECT  b.userID, name, prodName, CONCAT(mobile1, mobile2) AS '전화번호' -- userID는 b와 u 둘 다 있기 때문에 명시해줘야함
FROM buytbl b
INNER JOIN usertbl u
ON b.userID = u.userID
ORDER BY num;

## OUTER JOIN
USE sqldb;
SELECT U.userID, U.name, B.prodName, U.addr, CONCAT(U.mobile1, U.mobile2) AS '연락처'
	FROM usertbl U
		LEFT OUTER JOIN buytbl B
			ON U.userID = B.userID
	ORDER BY U.userID;

-- 구매기록이 없는 유령 회원 목록
SELECT U.userID, U.name, CONCAT(U.mobile1, U.mobile2) AS '연락처' FROM usertbl U
	LEFT OUTER JOIN buytbl B
		ON U.userID = B.userID
	WHERE B.prodName IS NULL
    ORDER BY U.userID;

-- 어느 영화에 어떤 배우가 출연했는지? -actor / film / film_actor
USE sakila;
SELECT a.first_name, a.last_name, f.title FROM film f
	INNER JOIN film_actor fa
	ON f.film_id = fa.film_id
	INNER JOIN actor a
	ON fa.actor_id = a.actor_id
ORDER BY a.first_name, a.last_name;

## CROSS JOIN
USE sqldb;
SELECT * FROM buytbl
	CROSS JOIN usertbl;

## SELF JOIN
USE sqldb;
CREATE TABLE empTbl (
	emp CHAR(3),
    manager CHAR(3),
    empTel VARCHAR(8)
);
INSERT INTO empTbl VALUES ('나사장', NULL, '0000'), ('김재무', '나사장', '2222'), ('김부장', '김재무', '2222-1'),
	('이부장', '김재무', '2222-2'), ('우대리', '이부장', '2222-2-1'), ('지사원', '이부장', '2222-2-2'), ('이영업', '나사장', '1111'),
    ('한과장', '이영업', '1111-1'), ('최정보', '나사장', '3333'), ('윤차장', '최정보', '3333-1'), ('이주임', '윤차장', '3333-1-1');
-- 우대리 상관 연락처 확인
SELECT A.emp AS '부하직원', B.emp AS '상사', B.empTel AS '상사 번호' FROM empTbl A
	INNER JOIN empTbl B
		ON A.manager = B.emp
	WHERE A.emp = '우대리';
