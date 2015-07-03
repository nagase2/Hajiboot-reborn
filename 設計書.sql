CREATE TABLE basket (
 basket_id CHAR(10) NOT NULL,
 basket_name CHAR(10),
 comment CHAR(10),
 basket_size CHAR(10)
);

ALTER TABLE basket ADD CONSTRAINT PK_basket PRIMARY KEY (basket_id);


CREATE TABLE item_mst (
 item_id CHAR(10) NOT NULL,
 item_name CHAR(10),
 item_expire_date CHAR(10),
 delete_flag CHAR(10)
);

ALTER TABLE item_mst ADD CONSTRAINT PK_item_mst PRIMARY KEY (item_id);


CREATE TABLE material_type (
 material_type_id CHAR(10) NOT NULL,
 delete_flag CHAR(10),
 material_type_name CHAR(10)
);

ALTER TABLE material_type ADD CONSTRAINT PK_material_type PRIMARY KEY (material_type_id);


CREATE TABLE content (
 content_id CHAR(10) NOT NULL,
 comment CHAR(10),
 material_type_id CHAR(10),
 basket_id CHAR(10),
 item_id CHAR(10),
 delete_flag CHAR(10)
);

ALTER TABLE content ADD CONSTRAINT PK_content PRIMARY KEY (content_id);


ALTER TABLE content ADD CONSTRAINT FK_content_0 FOREIGN KEY (material_type_id) REFERENCES material_type (material_type_id);
ALTER TABLE content ADD CONSTRAINT FK_content_1 FOREIGN KEY (basket_id) REFERENCES basket (basket_id);
ALTER TABLE content ADD CONSTRAINT FK_content_2 FOREIGN KEY (item_id) REFERENCES item_mst (item_id);


