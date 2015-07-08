create table customers (id int NOT NULL AUTO_INCREMENT PRIMARY KEY, 
first_name varchar(30), 
last_name varchar(30));

CREATE TABLE users (username VARCHAR(100) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255));
INSERT INTO users (username, encoded_password) VALUES ('user1', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);
INSERT INTO users (username, encoded_password) VALUES ('user2', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);

ALTER TABLE customers ADD username VARCHAR(100) NOT NULL DEFAULT 'user1';
ALTER TABLE customers ADD CONSTRAINT FK_CUSTOMERS_USERNAME FOREIGN KEY (username) REFERENCES users;

CREATE TABLE supplier (
 id bigserial ,
 first_name VARCHAR(100),
 last_name VARCHAR(100)
);
