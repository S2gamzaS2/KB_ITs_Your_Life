USE sqldb;

SELECT * FROM buytbl;

# 트랜잭션 시작
START TRANSACTION;

# num이 1, 2인 데이터 삭제
DELETE FROM buytbl WHERE num = 1;
DELETE FROM buytbl WHERE num = 2;

# num이 1, 2인 데이터 없음
SELECT * FROM buytbl;

## 가장 최근 트랜잭션 시작 전 상태로 되돌리기
ROLLBACK;

# 트랜잭션 시작 전 상태로 되돌아옴 (num=1, =2 데이터 O)
SELECT * FROM buytbl;

# AUTO COMMIT 모드 확인 (1: 켜짐, 0: 꺼짐)
SELECT @@autocommit;