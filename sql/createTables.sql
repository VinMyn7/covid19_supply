CREATE DATABASE covid19_supply;
use covid19_supply;

CREATE TABLE user
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);


CREATE TABLE entity1 
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);


SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE hospital(
hospital_id VARCHAR(10) UNIQUE NOT NULL,
hospital_name CHAR(50) NOT NULL,
hospital_address CHAR(100) UNIQUE NOT NULL,
delivery_id VARCHAR(10) UNIQUE NOT NULL,
PRIMARY KEY(hospital_id),
FOREIGN KEY(delivery_id) REFERENCES delivery_staff(delivery_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE customer(
customer_id VARCHAR(10) UNIQUE NOT NULL,
customer_name CHAR(50) NOT NULL,
customer_address CHAR(100) UNIQUE NOT NULL,
customer_age TINYINT UNSIGNED,
delivery_id VARCHAR(10) UNIQUE NOT NULL,
PRIMARY KEY(customer_id),
FOREIGN KEY(delivery_id) REFERENCES delivery_staff(delivery_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE supplier(
supplier_id VARCHAR(10) UNIQUE NOT NULL,
supplier_name CHAR(20) NOT NULL,
delivery_id VARCHAR(10) UNIQUE NOT NULL,
PRIMARY KEY(supplier_id)
);

CREATE TABLE product_stock (
product_id VARCHAR(10) UNIQUE NOT NULL,
product_name CHAR(20) UNIQUE NOT NULL,
available_quantity SMALLINT UNSIGNED UNIQUE,
supplier_id VARCHAR(10) UNIQUE NOT NULL,
PRIMARY KEY(product_id),
FOREIGN KEY(supplier_id) REFERENCES supplier(supplier_id)
ON DELETE CASCADE
ON UPDATE CASCADE
); 


CREATE TABLE delivery_staff(
delivery_id VARCHAR(10) UNIQUE NOT NULL,
delivery_staff_id VARCHAR(10) UNIQUE NOT NULL,
delivery_date DATE NOT NULL,
supplier_id VARCHAR(10) UNIQUE NOT NULL,
PRIMARY KEY(delivery_id),
FOREIGN KEY(supplier_id) REFERENCES supplier(supplier_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE hospital_order (
hospital_id VARCHAR(10) UNIQUE NOT NULL,
product_id VARCHAR(10) UNIQUE NOT NULL,
product_quantity SMALLINT UNSIGNED NOT NULL,
PRIMARY KEY(hospital_id,product_id),
FOREIGN KEY(hospital_id) REFERENCES hospital(hospital_id)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY(product_id) REFERENCES product_stock(product_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE customer_order (
customer_id VARCHAR(10) UNIQUE NOT NULL,
product_id VARCHAR(10) UNIQUE NOT NULL,
product_quantity SMALLINT UNSIGNED NOT NULL,
PRIMARY KEY(customer_id,product_id),
FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY(product_id) REFERENCES product_stock(product_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);



