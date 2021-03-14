/*
uncommented the drop statement to drop any database named application
this is used if you would like to have a fresh start on the database
where one already exists
*/
-- DROP DATABASE `application`;
CREATE DATABASE IF NOT EXISTS `application`;

CREATE TABLE IF NOT EXISTS `application`.`users`(
 `user_id` INT NOT NULL,
 `username` VARCHAR(100) NOT NULL,
 `password` VARCHAR(128) NOT NULL,
 CONSTRAINT `PK_user` PRIMARY KEY (`user_id`)
);

CREATE TABLE IF NOT EXISTS `application`.`products`(
`product_id` INT NOT NULL,
`price` FLOAT NOT NULL,
`quantity` INT NOT NULL,
`catagory` VARCHAR(50) NOT NULL,
CONSTRAINT `PK_products` PRIMARY KEY(`product_id`)
);

CREATE TABLE IF NOT EXISTS `application`.`user_product`(
`user_product_id` INT NOT NULL,
`user_id` INT NOT NULL,
`product_id` INT NOT NULL,
CONSTRAINT `PK_user_product` Primary Key (`user_product_id`),
CONSTRAINT `FK_user_product_users` FOREIGN KEY(`user_id`)
	REFERENCES `application`.`users`(`user_id`),
CONSTRAINT `FK_user_product_product` FOREIGN KEY(`product_id`)
	REFERENCES `application`.`products`(`product_id`)
);

CREATE TABLE IF NOT EXISTS `application`.`invoice`(
`invoice_id` INT NOT NULL,
`user_id` INT NOT NULL,
`date` DATETIME NOT NULL,
`price` FLOAT NOT NULL,
CONSTRAINT `PK_invoice_id` PRIMARY KEY (`invoice_id`),
CONSTRAINT `FK_invoice_users` FOREIGN KEY (`user_id`)
	REFERENCES `application`.`users`(`user_id`)
);