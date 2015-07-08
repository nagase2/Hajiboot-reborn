

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

INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (1,'item_name1',123,'2015-08-21', 22.22,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (2,'item_name2',123,'2015-08-21', 22.22,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (3,'item_name3',123,'2015-08-21', 22.22,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (4,'item_name4',123,'2015-08-21', 22.22,1,false);


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


