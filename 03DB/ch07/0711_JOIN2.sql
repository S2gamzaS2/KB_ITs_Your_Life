# 테이블 생성
USE sqldb;
CREATE TABLE stdtbl (
	stdName VARCHAR(10) NOT NULL PRIMARY KEY,
    addr CHAR(4) NOT NULL
);
CREATE TABLE clubtbl (
	clubName VARCHAR(10) NOT NULL PRIMARY KEY,
    roomNo CHAR(4) NOT NULL
);
-- 맵핑테이블
CREATE TABLE std_club_tbl (
	num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    stdName VARCHAR(10) NOT NULL,
    clubName VARCHAR(10) NOT NULL,
    FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
    FOREIGN KEY(clubName) REFERENCES clubtbl(clubName)
);

# 데이터 입력
INSERT INTO stdtbl VALUES ('김범수', '경남'), ('성시경', '서울'), ('조용필', '경기'), ('은지원', '경북'), ('바비킴', '서울');
INSERT INTO clubtbl VALUES ('수영', '101호'), ('바둑', '102호'), ('축구', '103호'), ('봉사', '104호');
INSERT INTO std_club_tbl VALUES (NULL, '김범수', '바둑'), (NULL, '김범수', '축구'), (NULL, '조용필', '축구'), (NULL, '은지원', '축구'), (NULL, '은지원', '봉사'), (NULL, '바비킴', '봉사');

# INNER JOIN
# 학생을 기준으로 학생 이름/지역/동아리/동아리방
SELECT S.stdName, S.addr, C.clubName, C.roomNo FROM stdtbl S
	INNER JOIN std_club_tbl SC
		ON S.stdName = SC.stdName
	INNER JOIN clubtbl C
		ON SC.clubName = C.clubName
ORDER BY S.stdName;	

# OUTER JOIN
# N : M
# 동아리에 가입하지 않은 학생도 출력 (학생 기준)
SELECT S.stdName, S.addr, SC.clubName, C.roomNo FROM stdtbl S
	LEFT OUTER JOIN std_club_tbl SC
		ON S.stdName = SC.stdName
	LEFT OUTER JOIN clubtbl C
		ON SC.clubName = C.clubName
	ORDER BY S.stdName;
# 가입한 학생이 없는 동아리도 출력 (동아리 기준)
SELECT C.clubName, C.roomNo, S.stdName, S.addr FROM clubtbl C
	LEFT OUTER JOIN std_club_tbl SC
		ON C.clubName = SC.clubName
	LEFT OUTER JOIN stdtbl S
		ON SC.stdName = S.stdName
	ORDER BY C.clubName;
# 가입하지 않은 학생도 출력, 가입한 학생이 없는 동아리도 출력 (UNION)
SELECT S.stdName, S.addr, SC.clubName, C.roomNo FROM stdtbl S
	LEFT OUTER JOIN std_club_tbl SC
		ON S.stdName = SC.stdName
	LEFT OUTER JOIN clubtbl C
		ON SC.clubName = C.clubName
UNION
SELECT S.stdName, S.addr, SC.clubName, C.roomNo FROM stdtbl S
	LEFT OUTER JOIN std_club_tbl SC
		ON S.stdName = SC.stdName
	RIGHT OUTER JOIN clubtbl C
		ON C.clubName = SC.clubName;