USE tabledb;
DROP TABLE IF EXISTS buytbl, usertbl;

# 테이블 생성
CREATE TABLE usertbl (
	userID CHAR(8),
    name VARCHAR(10),
    birthYear INT,
    addr CHAR(2),
    mobile1 CHAR(3),
    mobile2 CHAR(8),
    height SMALLINT,
    mDate DATE
);
CREATE TABLE buytbl (
	num INT AUTO_INCREMENT PRIMARY KEY,
    userid CHAR(8),
    prodName CHAR(6),
    groupName CHAR(4),
    price INT,
    amount SMALLINT
);

# 데이터 입력
INSERT INTO usertbl VALUES ('LSG', '이승기', 1987, '서울', '011', '11111111', 182, '2008-8-8'),
('KBS', '김범수', NULL, '경남', '011', '22222222', 173, '2012-4-4'),
('KKH', '김경호', 1871, '전남', '019', '33333333', 177, '2007-7-7'),
('JYP', '조용필', 1950, '경기', '011', '44444444', 166, '2009-4-4');
INSERT INTO buytbl VALUES (NULL, 'KBS', '운동화', NULL, 30, 2),
(NULL, 'KBS', '노트북', '전자', 1000, 1),
(NULL, 'JYP', '모니터', '전자', 200, 1),
(NULL, 'BBK', '모니터', '전자', 200, 5);

# 제약 조건 생성
## usertbl PK 설정
ALTER TABLE usertbl
	ADD CONSTRAINT PK_usertbl_userID
    PRIMARY KEY (userID);
## buytbl 외래 키 설정 -> 에러: buytbl에는 바비킴이 있는데 usertbl에는 바비킴이 없음
-- ALTER TABLE buytbl
-- 	ADD CONSTRAINT FK_usertbl_buytbl
--     FOREIGN KEY (userID)
--     REFERENCES usertbl (userID);
## 문제가 되는 바비킴 삭제
DELETE FROM buytbl WHERE userID = 'BBK';
## buytbl 외래키 다시 설정
ALTER TABLE buytbl
	ADD CONSTRAINT FK_usertbl_buytbl
		FOREIGN KEY (userID)
        REFERENCES usertbl (userID);

# 바비킴 데이터 다시 삽입 -> 에러: 아직도 usertbl에 바비킴이 없음
INSERT INTO buytbl VALUES (NULL, 'BBK', '모니터', '전자', 200, 5);
## 잠시 외래 키 제약 조건 비활성화(0) -> 데이터 입력 -> 다시 활성화(1)
SET foreign_key_checks = 0;
INSERT INTO buytbl VALUES (NULL, 'BBK', '모니터', '전자', 200, 5),
(NULL, 'KBS', '청바지', '의류', 50, 3),
(NULL, 'BBK', '메모리', '전자', 80, 10),
(NULL, 'SSK', '책', '서적', 15, 5),
(NULL, 'EJW', '책', '서적', 15, 2),
(NULL, 'EJW', '청바지', '의류', 50, 1),
(NULL, 'BBK', '운동화', NULL, 30, 2),
(NULL, 'EJW', '책', '서적', 15, 1),
(NULL, 'BBK', '운동화', NULL, 30, 2);
SET foreign_key_checks = 1;

# 데이터 수정
## 김범수 출생년도 1979, 김경호 1971로 변경
UPDATE usertbl SET birthYear=1979 WHERE userID='KBS';
UPDATE usertbl SET birthYear=1971 WHERE userID='KKH';

# CHECK 제약 조건 설정
## usertbl의 출생년도 1900~2023, NOT NULL
ALTER TABLE usertbl
	ADD CONSTRAINT CK_birthYear
    CHECK (
		(birthYear >= 1900 AND birthYear <= 2023) AND (birthYear IS NOT NULL)
    );
## 출생년도에 오류가 있는 데이터는 입력 불가 - 2999 는 제약 조건에 벗어남
INSERT INTO usertbl VALUES ('TKV', '태권뷔', 2999, '우주', NULL, NULL, 186, '2023-12-12');

# 정상 데이터 추가 입력
INSERT INTO usertbl VALUES ('SSK', '성시경', 1979, '서울', NULL, NULL, 186, '2013-12-12'),
('LJB', '임재범', 1963, '서울', '016', '66666666', 182, '2009-9-9'),
('YJS', '윤종신', 1969, '경남', NULL, NULL, 170, '2005-5-5'),
('EJW', '은지원', 1972, '경북', '011', '88888888', 174, '2014-3-3'),
('JKW', '조관우', 1965, '경기', '018', '99999999', 172, '2010-10-10'),
('BBK', '바비킴', 1973, '서울', '010', '00000000', 176, '2013-5-5');

# 구매테이블(buytbl) - 회원테이블(usertbl) 조인
## INNER JOIN - 구매한 회원 아이디, 회원 이름, 구매한 제품, 주소, 연락처 출력
SELECT B.userID, A.name, B.prodName, A.addr, CONCAT(A.mobile1, A.mobile2) AS '연락처'
	FROM buytbl B
		INNER JOIN usertbl A
         ON B.userID = A.userID
	ORDER BY B.userID;

## OUTER JOIN - 구매한 회원 아이디, 회원 이름, 구매한 제품, 주소, 연락처 출력
SELECT B.userID, A.name, B.prodName, A.addr, CONCAT(A.mobile1, A.mobile2) AS '연락처'
	FROM buytbl B
		LEFT OUTER JOIN usertbl A
			ON B.userID = A.userID
	ORDER BY B.userID;

# 회원 테이블의 userID가 바뀔 때 이와 관련되는 구매 테이블의 userID도 자동 변경되도록
## 외래 키 제약 조건 삭제 - ON UPDATE CASCADE 옵션과 함께 설정
ALTER TABLE buytbl
	DROP FOREIGN KEY FK_usertbl_buytbl;
ALTER TABLE buytbl
	ADD CONSTRAINT FK_usertbl_buytbl
		FOREIGN KEY (userID)
        REFERENCES usertbl (userID)
        ON UPDATE CASCADE;
        
## usertbl의 바비킴 ID를 변경 -> buytbl도 바뀌었는지 확인
UPDATE usertbl SET userID = 'VVK' WHERE userID = 'BBK';
SELECT B.userID, A.name, B.prodName, A.addr, CONCAT(A.mobile1, A.mobile2) AS '연락처'
	FROM buytbl B
		INNER JOIN usertbl A
			ON B.userID = A.userID
	ORDER BY B.userID;

# 회원 테이블에서 데이터가 삭제될 때 구매 테이블 기록도 삭제되도록
## 외래 키 제약 조건 삭제 - ON DELETE CASCADE 옵션
ALTER TABLE buytbl
	DROP FOREIGN KEY FK_usertbl_buytbl;
ALTER TABLE buytbl
	ADD CONSTRAINT FK_usertbl_buytbl
		FOREIGN KEY (userID)
		REFERENCES usertbl (userID)
        ON UPDATE CASCADE
        ON DELETE CASCADE;
## 회원테이블에서 삭제 한 후 구매 테이블도 삭제되었는지 확인
DELETE FROM usertbl WHERE userID='VVK';
SELECT * FROM usertbl;

# usertbl에서 CHECK 제약조건이 걸린 출생년도 열 삭제
## MySQL은 CHECK 제약조건이 설정된 열은 제약 조건을 무시하고 제거함
ALTER TABLE usertbl
	DROP COLUMN birthYear;
