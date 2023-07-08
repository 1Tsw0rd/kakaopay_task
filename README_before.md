# kakaopay_task
항해99 하이커스 카카오페이 서버 개발 문제

1. DB모델링 및 ERD
![image](https://user-images.githubusercontent.com/31820402/222477931-dfd63627-f274-431c-8c54-19a18e581004.png)

![image](https://user-images.githubusercontent.com/31820402/222477569-04a06610-aac3-4c50-a117-b2b5647eeff9.png)

2. API명세

![image](https://user-images.githubusercontent.com/31820402/222476844-bd65ef8e-85ee-4c4d-9ac3-980be8479d58.png)

3. DDL 쿼리문

```MySQL
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
    password VARCHAR(255) NOT NULL COMMENT '비밀번호',
    point BIGINT NOT NULL COMMENT '포인트' DEFAULT 1000,
    PRIMARY KEY (user_id)
);

CREATE TABLE orders (
	order_id BIGINT NOT NULL COMMENT '주무번호' AUTO_INCREMENT,
	user_id BIGINT NOT NULL COMMENT '사용자번호',
	menu_id BIGINT NOT NULL COMMENT '메뉴번호',
    ordered_date  DATETIME NOT NULL COMMENT '주문일' DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (order_id),
    FOREIGN KEY(user_id)
    REFERENCES users(user_id) ON UPDATE CASCADE,
    FOREIGN KEY(user_id)
    REFERENCES users(user_id) ON UPDATE CASCADE
);

DESC menus;
DESC users;
DESC orders;
```
