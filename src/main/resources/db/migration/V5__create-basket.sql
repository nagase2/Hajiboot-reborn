CREATE TABLE basket (
 basket_id INT NOT NULL,
 basket_name CHAR(100),
 comment CHAR(500),
 basket_size INT,
 version INT,
 basket_price FLOAT(20),
 delete_flag BIT(1)
);

ALTER TABLE basket ADD CONSTRAINT PK_basket PRIMARY KEY (basket_id);


CREATE TABLE item_mst (
 item_id INT NOT NULL,
 item_name CHAR(100),
 item_expire_date CHAR(10),
 price FLOAT(20),
 version INT,
 delete_flag BIT(1)
);

ALTER TABLE item_mst ADD CONSTRAINT PK_item_mst PRIMARY KEY (item_id);


CREATE TABLE item_type (
 item_type_id INT NOT NULL,
 delete_flag BIT(1),
 material_type_name CHAR(100)
);

ALTER TABLE item_type ADD CONSTRAINT PK_item_type PRIMARY KEY (item_type_id);


CREATE TABLE content (
 content_id INT NOT NULL,
 basket_id INT,
 item_type_id INT,
 item_id INT,
 comment VARCHAR(500),
 content_count FLOAT(20),
 version INT,
 delete_flag BIT(1)
);

ALTER TABLE content ADD CONSTRAINT PK_content PRIMARY KEY (content_id);


ALTER TABLE content ADD CONSTRAINT FK_content_0 FOREIGN KEY (basket_id) REFERENCES basket (basket_id);
ALTER TABLE content ADD CONSTRAINT FK_content_1 FOREIGN KEY (item_type_id) REFERENCES item_type (item_type_id);
ALTER TABLE content ADD CONSTRAINT FK_content_2 FOREIGN KEY (item_id) REFERENCES item_mst (item_id);


