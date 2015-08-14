

CREATE TABLE mst_item_type(
 item_type_id INT NOT NULL PRIMARY KEY,
 item_type_name VARCHAR(110),
 delete_flag boolean
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
 delete_flag boolean
);


CREATE TABLE content (
 content_id bigint NOT NULL PRIMARY KEY,
 item_id INT,
 content_name VARCHAR(100),count INT,comment VARCHAR(500),
 version bigint,
 updated_function VARCHAR(100),
 created_function VARCHAR(100),
 delete_flag boolean
);


CREATE TABLE shopping_basket (
 basket_id INT NOT NULL PRIMARY KEY,
 content_id INT,
 comment VARCHAR(500),
 version INT,
 delete_flag boolean,
 purchased_date DATE
);


