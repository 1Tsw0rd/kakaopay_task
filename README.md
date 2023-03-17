# kakaopay_task
항해99 하이커스 카카오페이 서버 개발 문제

1. DB모델링 및 ERD
![image](https://user-images.githubusercontent.com/31820402/224357989-b7130d5e-485d-4fcd-b6a3-b5c11cd27eb2.png)

![image](https://user-images.githubusercontent.com/31820402/224358108-588e6695-34af-417c-b7b3-5efd54044d81.png)

![image](https://user-images.githubusercontent.com/31820402/224358253-a492b4ab-9f9a-41f7-a06f-8e6d0614638e.png)

2. API명세

![image](https://user-images.githubusercontent.com/31820402/224333817-a8a59723-5eaf-43e0-a0b5-2de7ab927a72.png)

3. DDL 쿼리문

```MySQL
DROP TABLE points;
DROP TABLE orders;
DROP TABLE users;
DROP TABLE menus;

CREATE TABLE menus (
    menu_id BIGINT NOT NULL COMMENT '메뉴번호' AUTO_INCREMENT,
    menu_name VARCHAR(50) NOT NULL COMMENT '메뉴명',
    price BIGINT NOT NULL COMMENT '가격',
    insertion_date DATETIME NOT NULL COMMENT '등록일' DEFAULT CURRENT_TIMESTAMP,
    modification_date DATETIME NOT NULL COMMENT '수정일' DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (menu_id)
);

CREATE TABLE users (
    user_id BIGINT NOT NULL COMMENT '사용자번호' AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL COMMENT '사용자명',
    point BIGINT NOT NULL COMMENT '포인트' DEFAULT 1000,
    PRIMARY KEY (user_id)
);

CREATE TABLE orders (
    order_id BIGINT NOT NULL COMMENT '주문번호' AUTO_INCREMENT,
    user_id BIGINT NOT NULL COMMENT '사용자번호',
    menu_id BIGINT NOT NULL COMMENT '메뉴번호',
    ordered_date  DATETIME NOT NULL COMMENT '주문일' DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (order_id)
);

CREATE TABLE points (
    point_id BIGINT NOT NULL COMMENT '포인트내역번호' AUTO_INCREMENT,
    user_id BIGINT NOT NULL COMMENT '사용자번호',
    point BIGINT NOT NULL COMMENT '포인트',
    insertion_date DATETIME NOT NULL COMMENT '등록일' DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (point_id)
);

DESC menus;
DESC users;
DESC orders;
DESC points;

ALTER TABLE orders DROP INDEX idx_orders_user_id;
ALTER TABLE orders DROP INDEX idx_orders_menu_id;
ALTER TABLE points DROP INDEX idx_points_user_id; -- points

CREATE INDEX idx_orders_user_id ON orders (user_id);
CREATE INDEX idx_orders_menu_id ON orders (menu_id);
CREATE INDEX idx_points_user_id ON points (user_id); -- points

SHOW INDEX FROM orders;
SHOW INDEX FROM points;

INSERT INTO menus (menu_name, price) VALUES ("아메리카노(ICE)", 2000);
INSERT INTO menus (menu_name, price) VALUES ("아메리카노(HOT)", 1500);
INSERT INTO menus (menu_name, price) VALUES ("콜드브루", 3000);
INSERT INTO menus (menu_name, price) VALUES ("카페라떼", 2500);
INSERT INTO menus (menu_name, price) VALUES ("몬테카를로", 8000);

INSERT INTO users (user_name) VALUES ("1man");
INSERT INTO users (user_name) VALUES ("2man");
INSERT INTO users (user_name) VALUES ("3man");
INSERT INTO users (user_name) VALUES ("4man");
INSERT INTO users (user_name) VALUES ("5man");

select * from menus;
select * from users;
```
