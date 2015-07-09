

CREATE TABLE mst_item_type(
 item_type_id INT NOT NULL PRIMARY KEY,
 item_type_name VARCHAR(110),
 delete_flag BIT(1)
);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (1,'本',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (2,'衣類',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (3,'靴',false);

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

INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (1,'日本の歴史１',1,'2015-08-21', 300,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (2,'日本の歴史２',1,'2015-08-21', 980,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (3,'日本の歴史３',1,'2015-08-21', 980,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (4,'レザージャケット',2,'2015-08-21', 20000,1,false);


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


