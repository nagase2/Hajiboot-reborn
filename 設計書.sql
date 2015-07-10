CREATE TABLE mst_item_type (
 item_type_id INT NOT NULL PRIMARY KEY,
 material_type_name VARCHAR(110),
 delete_flag BIT(1)
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
 count INT,
 comment VARCHAR(500),
 version INT,
 updated_function VARCHAR(100),
 created_function VARCHAR(100),
 delete_flag BIT(1)
);


