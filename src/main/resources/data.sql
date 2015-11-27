
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (1,'本',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (2,'衣類',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (3,'靴',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (4,'家電',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (5,'PC',false);
INSERT INTO mst_item_type (item_type_id, item_type_name, delete_flag) VALUES (6,'映画',false);

INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (1,'日本の歴史１',1,'2015-08-21', 300,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (2,'日本の歴史２',3,'2015-08-21', 980,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (3,'日本の歴史３',4,'2015-08-21', 980,1,false);
INSERT INTO mst_item (item_id, item_name,item_type_id,item_expire_date,price,version, delete_flag) VALUES (4,'レザージャケット',6,'2015-08-21', 20000,1,false);



Insert into customers(id,first_name,last_name) values(1,'5nobita','nobi');
Insert into customers(id,first_name,last_name) values(2,'nnnnn','nobi');
Insert into customers(id,first_name,last_name) values(3,'llllllll','nobi');
Insert into customers(id,first_name,last_name) values(4,'V_4 data','Newdata');
Insert into customers(id,first_name,last_name) values(5,'V_3 data','Newdata');
Insert into customers(id,first_name,last_name) values(6,'V_3 data','Newdata');
Insert into customers(id,first_name,last_name) values(7,'V_3 data','Newdata');
Insert into customers(id,first_name,last_name) values(8,'V_3 data','Newdata');
Insert into customers(id,first_name,last_name) values(9,'V_3 data','Newdata');


INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (1,2,999,'aaa','this is comment',3,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (1,2,777,'this is name','this is comment',2,'com.controller.abc', 'com.controller.bcd',false);
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (2,3,888,'this is name','this is comment',4,'com.controller.abc', 'com.controller.bcd',false);
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
INSERT INTO content (content_id, item_id,count,content_name,comment,version,updated_function,created_function,delete_flag) 
VALUES (2,4,123,'★消されたデータ','this is comment',1,'com.controller.abc', 'com.controller.bcd',true);

INSERT INTO content (detail_id, content_id, detail_name, price) 
VALUES (1,1,'No.1',300);
INSERT INTO content (detail_id, content_id, detail_name, price) 
VALUES (1,2,'No.1',300);
INSERT INTO content (detail_id, content_id, detail_name, price) 
VALUES (1,3,'No.1',300);
INSERT INTO content (detail_id, content_id, detail_name, price) 
VALUES (2,1,'No.1',300);
INSERT INTO content (detail_id, content_id, detail_name, price) 
VALUES (2,2,'No.1',300);
INSERT INTO content (detail_id, content_id, detail_name, price) 
VALUES (2,3,'No.1',300);
 

INSERT INTO users (username, encoded_password) VALUES ('user1', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);
INSERT INTO users (username, encoded_password) VALUES ('user2', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);
