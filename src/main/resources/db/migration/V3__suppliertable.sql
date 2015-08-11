

CREATE TABLE mst_item_type(
 item_type_id INT NOT NULL PRIMARY KEY,
 item_type_name VARCHAR(110),
 delete_flag boolean
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
 delete_flag boolean
);

INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (1,'日本の歴史１',1,'2015-08-21', 300,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (2,'日本の歴史２',1,'2015-08-21', 980,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (3,'日本の歴史３',1,'2015-08-21', 980,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (4,'レザージャケット',2,'2015-08-21', 20000,1,false);


CREATE TABLE content (
 content_id bigint NOT NULL PRIMARY KEY,
 item_id INT,
 content_name VARCHAR(100),count INT,comment VARCHAR(500),
 version bigint,
 updated_function VARCHAR(100),
 created_function VARCHAR(100),
 delete_flag boolean
);

INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (1,2,999,'aaa','this is comment',3,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (2,2,777,'this is name','this is comment',2,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (3,3,888,'this is name','this is comment',4,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (4,4,888,'aaa','this is comment',4,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (5,1,888,'aaa','this is comment',4,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (6,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (7,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (8,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (9,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (10,1,888,'aaa','this is comment',1,'com.controller.abc', 'com.controller.bcd',false);


CREATE TABLE shopping_basket (
 basket_id INT NOT NULL PRIMARY KEY,
 content_id INT,
 comment VARCHAR(500),
 version INT,
 delete_flag boolean,
 purchased_date DATE
);


