DROP DATABASE IF EXISTS widgetarium;
CREATE DATABASE widgetarium;

USE widgetarium;

DROP TABLE IF EXISTS Categories;
CREATE TABLE Categories (
	CategoryId INTEGER PRIMARY KEY,
	Name VARCHAR(64) NOT NULL
);

DROP TABLE IF EXISTS Products;
CREATE TABLE Products (
	ProductId INTEGER PRIMARY KEY,
	Name VARCHAR(64) NOT NULL,
	Description VARCHAR(255) NULL,
	Price DECIMAL(10,2) NOT NULL,
	CategoryId INTEGER NOT NULL
);

GRANT ALL ON widgetarium.* TO 'gimli' 
IDENTIFIED BY 'pwd';
GRANT ALL ON widgetarium.* TO 'gimli'@'localhost' 
IDENTIFIED BY 'pwd';
GRANT ALL ON widgetarium.* TO 'gimli'@'localhost.localdomain' 
IDENTIFIED BY 'pwd';

FLUSH PRIVILEGES;

INSERT INTO Categories VALUES(0, 'Widgets');
INSERT INTO Categories VALUES(1, 'Wotsits');
INSERT INTO Categories VALUES(2, 'Thingys');

INSERT INTO Products 
VALUES(1, 'Standard Widget', 'A standard widget with no useful features', 12.99, 0);
INSERT INTO Products 
VALUES(2, 'Professional Widget', 'A widget for professionals', 14.99, 0);
INSERT INTO Products 
VALUES(3, 'Developer Widget', 'Development use only widget', 2.99, 0);
INSERT INTO Products 
VALUES(4, 'Enterprise Widget', 'Less extra value - lots extra cost', 18.99, 0);
INSERT INTO Products 
VALUES(5, 'Community Widget', 'Widget code included!!!', 5.99, 0);

INSERT INTO Products 
VALUES(6, 'Standard Wotsit', 'A standard wotsit with no useful features', 12.99, 1);
INSERT INTO Products 
VALUES(7, 'Professional Wotsit', 'A wotsit for professionals', 15.99, 1);
INSERT INTO Products 
VALUES(8, 'Developer Wotsit', 'Development use only wotsit', 3.99, 1);
INSERT INTO Products 
VALUES(9, 'Enterprise Wotsit', 'Less extra value - lots extra cost', 21.99, 1);
INSERT INTO Products 
VALUES(10, 'Community Wotsit', 'Wotsit code included!!!', 6.99, 1);

INSERT INTO Products 
VALUES(11, 'Standard Thingy', 'A standard thingy with no useful features', 18.99, 2);
INSERT INTO Products 
VALUES(12, 'Professional Thingy', 'A thingy for professionals', 12.99, 2);
INSERT INTO Products 
VALUES(13, 'Developer Thingy', 'Development use only thingy', 1.99, 2);
INSERT INTO Products 
VALUES(14, 'Enterprise Thingy', 'Less extra value - lots extra cost', 14.99, 2);
INSERT INTO Products
VALUES(15, 'Community Thingy', 'Thingy code included!!!', 2.99, 2);
