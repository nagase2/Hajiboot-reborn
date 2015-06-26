create table customers (id bigint NOT NULL /*AUTO_INCREMENT PRIMARY KEY*/, 
first_name varchar(30), 
last_name varchar(30));

CREATE TABLE users (username VARCHAR(100) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255));
INSERT INTO users (username, encoded_password) VALUES ('user1', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);
INSERT INTO users (username, encoded_password) VALUES ('user2', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);
ALTER TABLE customers ADD username VARCHAR(100) NOT NULL DEFAULT 'user1';
ALTER TABLE customers ADD CONSTRAINT FK_CUSTOMERS_USERNAME FOREIGN KEY (username) REFERENCES users;

CREATE TABLE basket (
 basket_id INT NOT NULL PRIMARY KEY,
 basket_name CHAR(100),
 comment CHAR(500),
 basket_size INT,
 version INT,
 basket_price FLOAT(20),
 delete_flag BIT(1)
);


CREATE TABLE item_mst (
 item_id INT NOT NULL PRIMARY KEY,
 item_name CHAR(100),
 item_expire_date CHAR(10),
 price FLOAT(20),
 version INT,
 delete_flag BIT(1)
);


CREATE TABLE item_type (
 item_type_id INT NOT NULL PRIMARY KEY,
 delete_flag BIT(1),
 material_type_name CHAR(100)
);


CREATE TABLE content (
 content_id INT NOT NULL PRIMARY KEY,
 basket_id INT,
 item_type_id INT,
 item_id INT,
 comment VARCHAR(500),
 content_count FLOAT(20),
 version INT,
 delete_flag BIT(1)
);
