CREATE TABLE IF NOT EXISTS user (

user_id INT NOT NULL AUTO_INCREMENT,
password VARCHAR(100) NOT NULL,
username VARCHAR(100) NOT NULL,
PRIMARY KEY (user_id)

);


CREATE TABLE IF NOT EXISTS product (

product_id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
description VARCHAR(500) NOT NULL,
price DECIMAL(10, 2) NOT NULL,
quantity INT NOT NULL,
PRIMARY KEY (product_id)

);

insert into user (password, username) values ('password123', 'matt12ader');

insert into product (name, description, price, quantity) values ('Monitor', 'A device used for viewing content on a computer', 149.99, 10);
insert into product (name, description, price, quantity) values ('Keyboard', 'A device used for inputing text on a computer', 29.99, 75);
insert into product (name, description, price, quantity) values ('Graphics Card', 'A device used for processing video output on a computer', 599.99, 20);