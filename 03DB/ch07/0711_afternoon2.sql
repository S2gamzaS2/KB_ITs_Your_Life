-- 고객 테이블 생성
CREATE TABLE customers (
	customer_id INT PRIMARY KEY,
    customer_name VARCHAR(10)
);
CREATE TABLE orders (
	order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
CREATE TABLE categories (
	category_id INT PRIMARY KEY,
    category_name VARCHAR(100)
);

-- 상품 테이블 생성
CREATE TABLE products (
	product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    product_price INT,
    category_id INT,
    FOREIGN KEY(category_id) REFERENCES categories(category_id)
);

-- 주문 상세 테이블 생성
CREATE TABLE order_details (
	order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY(order_id) REFERENCES orders(order_id),
    FOREIGN KEY(product_id) REFERENCES products(product_id)
);

-- 고객 테이블에 데이터 삽입
INSERT INTO customers (customer_id, customer_name) VALUES
(1, '김시완'),
(2, '이효석'),
(3, '김연비'),
(4, '최호진'),
(5, '김동준'),
(6, '최현수'),
(7, '권오현');

-- 카테고리 테이블에 데이터 삽입
INSERT INTO categories (category_id, category_name) VALUES
(1, '전자기기'),
(2, '주변기기');


-- 상품 테이블에 데이터 삽입
INSERT INTO products (product_id, product_name, product_price, category_id) VALUES
(1, '맥북에어', 650000, 1),
(2, '맥북프로', 700000, 1),
(3, '맥북프로맥스', 750000, 1),
(4, '맥북파우치', 10000, 2),
(5, 'DT-35키보드', 20000, 2),
(6, '독거미키보드', 50000, 2);

-- 주문 테이블에 데이터 삽입
INSERT INTO orders (order_id, customer_id, order_date) VALUES
(1, 1, '2024-06-01'),
(2, 2, '2023-06-02'),
(3, 3, '2023-06-03'),
(4, 4, '2023-06-04'),
(5, 5, '2023-06-05'),
(6, 6, '2023-06-06'),
(7, 7, '2023-06-07');

-- 주문 상세 테이블에 데이터 삽입
INSERT INTO order_details (order_id, product_id, quantity) VALUES
(1, 1, 1),
(1, 4, 1),
(2, 2, 1),
(3, 3, 1),
(4, 5, 1),
(5, 6, 1),
(6, 6, 1),
(7, 6, 1);

SELECT * FROM customers;
SELECT * FROM categories;
SELECT * from orders;
SELECT * FROM products;
SELECT * FROM order_details;

-- 전체 합치기
SELECT *
FROM customers C
	INNER JOIN orders O
		ON C.customer_id = O.customer_id
	INNER JOIN order_details OD
		ON O.order_id = OD.order_id
	INNER JOIN products P
		ON OD.product_id = P.product_id
	INNER JOIN categories CT
		ON P.category_id = CT.category_id;

-- 사용자별 주문 총액
SELECT 
	C.customer_name, SUM(P.product_price * OD.quantity) AS '총액'
FROM customers C
	INNER JOIN orders O
		ON C.customer_id = O.customer_id
	INNER JOIN order_details OD
		ON O.order_id = OD.order_id
	INNER JOIN products P
		ON OD.product_id = P.product_id
	GROUP BY C.customer_name
    ORDER BY 총액 DESC;

-- 각 물품이 몇 개 팔렸나
SELECT P.product_name, SUM(OD.quantity) AS 총판매수
FROM products P
	INNER JOIN order_details OD
		ON P.product_id = OD.product_id
	GROUP BY P.product_name
    ORDER BY 총판매수 DESC;