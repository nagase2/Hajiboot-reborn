CREATE TABLE mst_item_category (
 item_type_id INT NOT NULL PRIMARY KEY,
 delete_flag BIT(1),
 material_type_name VARCHAR(110)
);


CREATE TABLE purchase_history (
 purchase_history_id INT NOT NULL PRIMARY KEY,
 purchase_date DATE
);


CREATE TABLE mst_item (
 item_id INT NOT NULL PRIMARY KEY,
 item_name VARCHAR(100),
 item_type_id INT,
 item_expire_date TIMESTAMP(10),
 price FLOAT(20),
 version INT,
 delete_flag BIT(1)
);


CREATE TABLE content (
 content_id INT NOT NULL PRIMARY KEY,
 item_id INT,
 comment VARCHAR(500),
 purchased_price FLOAT(20),
 version INT,
 delete_flag BIT(1)
);


CREATE TABLE shopping_basket (
 basket_id INT NOT NULL PRIMARY KEY,
 content_id INT,
 comment VARCHAR(500),
 version INT,
 delete_flag BIT(1),
 purchased_date DATE
);


