USE sqldb;

SELECT * FROM buytbl;

# 유저별로 상품을 몇개 구매?
SELECT userId, SUM(amount) AS '총 구매량'
FROM buytbl
GROUP BY userId;

# 유저별로 구매 목록
## GROUP_CONCAT(COL, 구분자)
SELECT userId, GROUP_CONCAT(prodName SEPARATOR ', ')
FROM buytbl
GROUP BY userId;
