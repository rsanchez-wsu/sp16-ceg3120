-- create and select the database
DROP DATABASE IF EXISTS test_db;
CREATE DATABASE test_db;
USE test_db;

-- create the tables
CREATE TABLE inventory (
  productNumber 	INT(5) 		NOT NULL AUTO_INCREMENT,
  productName 		VARCHAR(200) 	NOT NULL,
  productDescription 	VARCHAR(300),
  productCategory 	VARCHAR(200) 	NOT NULL,
  productRating 	INT(5) 		DEFAULT 0,
  price 		DECIMAL(10, 2) 	NOT NULL,
  quantity 		INT(10) 	NOT NULL,
  PRIMARY KEY (productNumber)  
);

-- populate the database
INSERT INTO inventory (productName, productDescription, productCategory, price, quantity)
VALUES
('Chocolate Doughnuts','Chocolate lovers take note! We take our Original Glazed doughnut one simple, yet delicious, step further by hand-dipping it in smooth, creamy, delectable chocolate icing.',
 'doughnut',1.50,20),
('Butter Rum Cupcakes','An absolutely sinful cupcake that is perfect for grownup parties','cupcake',2.50, 50),
('Banana Bread','Banana bread is a type of bread that is made with mashed bananas. It is often a moist, sweet, cake-like  quick bread; however, there are some banana bread recipes that are traditional-style rye breads', 'bread', 6.00, 15);

-- delete previously created users
DROP USER 'dbuser'@'localhost';

-- create dbuser
CREATE USER 'dbuser'@'localhost' IDENTIFIED BY 'user';
SET PASSWORD FOR 'dbuser'@'localhost' = PASSWORD('password');

-- create privileges for dbuser
GRANT SELECT, INSERT, DELETE, UPDATE
ON test_db.*
TO dbuser@localhost;
