CREATE DATABASE WebShop DEFAULT CHARACTER set utf8;

USE WebShop;

CREATE TABLE Country (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  code VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE Place (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  zip_code VARCHAR(45) NULL,
  Country_id INT NULL,
  PRIMARY KEY (id),
  INDEX fk_Place_Countrey1_idx (Country_id ASC),
  CONSTRAINT fk_Place_Countrey1
    FOREIGN KEY (Country_id)
    REFERENCES Country (id));

CREATE TABLE Address (
  id INT NOT NULL AUTO_INCREMENT,
  Place_id INT NULL,
  street VARCHAR(45) NULL,
  number VARCHAR(45) NULL,
  PRIMARY KEY (id),
  INDEX fk_Address_Place1_idx (Place_id ASC),
  CONSTRAINT fk_Address_Place1
    FOREIGN KEY (Place_id)
    REFERENCES Place (id));

CREATE TABLE User (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NULL,
  last_name VARCHAR(45) NULL,
  Address_id INT NULL,
  email VARCHAR(45) NULL,
  PRIMARY KEY (id),
  INDEX fk_User_Address1_idx (Address_id ASC),
  CONSTRAINT fk_User_Address1
    FOREIGN KEY (Address_id)
    REFERENCES Address (id));

CREATE TABLE Product (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(150) NULL,
  price DOUBLE NULL,
  PRIMARY KEY (id));

CREATE TABLE ShoppingCartItem (
  id INT NOT NULL AUTO_INCREMENT,
  count INT NULL,
  User_id INT NOT NULL,
  Product_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_ShoppingCartItem_User_idx (User_id ASC),
  INDEX fk_ShoppingCartItem_Product1_idx (Product_id ASC),
  CONSTRAINT fk_ShoppingCartItem_User
    FOREIGN KEY (User_id) REFERENCES User (id),
  CONSTRAINT fk_ShoppingCartItem_Product1
    FOREIGN KEY (Product_id) REFERENCES Product (id));

INSERT INTO Country (id, name, code) VALUES (1, 'Srbija', 'rs');
INSERT INTO Country (id, name, code) VALUES (2, 'Bosna i Hercegovina', 'bih');
INSERT INTO Country (id, name, code) VALUES (3, 'Crna Gora', 'cg');
INSERT INTO Country (id, name, code) VALUES (4, 'Switzerland', 'ch');
INSERT INTO Country (id, name, code) VALUES (5, 'Slovenija', 'si');

INSERT INTO Place (id, name, zip_code, Country_id) VALUES (1, 'Beograd', '11000', 1);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (2, 'Novi Sad', '21000', 1);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (3, 'Kragujevac', '34000', 1);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (4, 'Niš', '18000', 1);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (5, 'Sarajevo', '71000', 2);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (6, 'Bjeljina', '76300', NULL);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (7, 'Podgorica', '81000', 3);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (8, 'Nikšić', '81400', 3);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (9, 'Kolašin', '81210', 3);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (10, 'Bar', '85000', 3);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (11, 'Zurich', '8000', 4);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (12, 'Basel', '4000', NULL);
INSERT INTO Place (id, name, zip_code, Country_id) VALUES (13, 'Lausanne', '1000', 4);

INSERT INTO Address (id, Place_id, street, number) VALUES (1, 1, 'Bulevar Revolucije', '16/5');
INSERT INTO Address (id, Place_id, street, number) VALUES (2, NULL, 'Bulevar Mihajla Pupina', '60/12');
INSERT INTO Address (id, Place_id, street, number) VALUES (3, 2, 'Fruskogorska', '11');
INSERT INTO Address (id, Place_id, street, number) VALUES (4, 2, 'Radičevićava', '7');
INSERT INTO Address (id, Place_id, street, number) VALUES (5, 5, 'Drvarska ', '13');
INSERT INTO Address (id, Place_id, street, number) VALUES (6, 5, 'Đure Daničića', '7');
INSERT INTO Address (id, Place_id, street, number) VALUES (7, 10, 'Novi bulevar', '35/2');
INSERT INTO Address (id, Place_id, street, number) VALUES (8, 6, 'Balkanska', '53');
INSERT INTO Address (id, Place_id, street, number) VALUES (9, NULL, 'Rue de Geneve', '107');
INSERT INTO Address (id, Place_id, street, number) VALUES (10, 11, 'Pelikanstrasse', '42');
INSERT INTO Address (id, Place_id, street, number) VALUES (11, 11, 'Lagerstrasse', '10a');
INSERT INTO Address (id, Place_id, street, number) VALUES (12, 2, 'Kraljevića Marka', '35/5');
INSERT INTO Address (id, Place_id, street, number) VALUES (13, 2, 'Stražilovska', '8');
INSERT INTO Address (id, Place_id, street, number) VALUES (14, NULL, 'Lilike Bem', '12/7');
INSERT INTO Address (id, Place_id, street, number) VALUES (15, 1, 'Baba Višnjina', '3a');
INSERT INTO Address (id, Place_id, street, number) VALUES (16, 2, 'Bulevar Cara Lazara', '22');

INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (1, 'Dijana', 'Mlađenovid', 1, 'dijana78@gmail.com');
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (2, 'Jelena', 'Živančević', 2, NULL);
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (3, 'Jovan', 'Vojinović', NULL, 'jvojnovic@yahoo.com');
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (4, 'Jovana', 'Nikolić', 4, 'jovananik@gmail.com');
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (5, 'Ana', 'Dabović', 5, NULL);
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (6, 'Boris', 'Popadić', 6, 'popboris@gmail.com');
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (7, 'Matija', 'Petrović', NULL, NULL);
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (8, 'Aleksandra', 'Stevanović', 8, NULL);
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (9, 'Miloš', 'Stanojković', 9, 'milosstanojkovic@gmail.com');
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (10, 'Ivana', 'Perković', 10, NULL);
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (11, 'Aleksandra', 'Ćirić', 11, 'aciric@yahoo.com');
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (12, 'Mihajlo', 'Stanojević', NULL, NULL);
INSERT INTO User (id, first_name, last_name, Address_id, email) VALUES (13, 'Jhony', 'Dope', NULL, NULL);

INSERT INTO Product (id, name, price) VALUES (1, 'Canon digitalni fotoaparat PowerShot SX 530HS', 38.999);
INSERT INTO Product (id, name, price) VALUES (2, 'Canon DSLR fotoaparat EOS 100D BODY', 70.999);
INSERT INTO Product (id, name, price) VALUES (3, 'Canon DSLR fotoaparat EOS 1100D + objektiv EFS18-55IS', 44.999);
INSERT INTO Product (id, name, price) VALUES (4, 'Canon DSLR fotoaparat EOS 1200D + objektiv EFS1855 II', 58.999);
INSERT INTO Product (id, name, price) VALUES (5, 'Canon DSLR fotoaparat EOS 1200D + objektiv EFS1855 III', 53.999);
INSERT INTO Product (id, name, price) VALUES (6, 'Canon DSLR fotoaparat EOS 70D + objektiv EF-S18-135 IS', 164.989);
INSERT INTO Product (id, name, price) VALUES (7, 'Canon DSLR fotoaparat EOS 70D + Objektiv EF-S18-55 IS STM W', 155.999);
INSERT INTO Product (id, name, price) VALUES (8, 'Canon DSLR fotoaparat EOS M i objektiv 18 55IS RED', 47.499);
INSERT INTO Product (id, name, price) VALUES (9, 'Canon fotoaparat EOS 700D + objektiv 18 55IS', 103.999);
INSERT INTO Product (id, name, price) VALUES (10, 'Canon fotoaparat IXUS 132 SILVER', 11.689);
INSERT INTO Product (id, name, price) VALUES (11, 'Canon fotoaparat IXUS 135 SILVER', 14.489);
INSERT INTO Product (id, name, price) VALUES (12, 'Canon fotoaparat IXUS 140 SILVER', 21.999);
INSERT INTO Product (id, name, price) VALUES (13, 'Canon fotoaparat IXUS 155 BK KIT', 16.989);
INSERT INTO Product (id, name, price) VALUES (15, 'Canon fotoaparat IXUS 155 BLUE', 14.990);
INSERT INTO Product (id, name, price) VALUES (16, 'Canon fotoaparat IXUS 155 PINK', 15.999);
INSERT INTO Product (id, name, price) VALUES (17, 'Canon fotoaparat IXUS 155 RED', 14.990);
INSERT INTO Product (id, name, price) VALUES (18, 'Canon fotoaparat IXUS 155 SI KIT', 17.499);
INSERT INTO Product (id, name, price) VALUES (19, 'Canon fotoaparat IXUS 160 BL', 11.990);
INSERT INTO Product (id, name, price) VALUES (20, 'Canon fotoaparat IXUS 160 RE', 11.990);
INSERT INTO Product (id, name, price) VALUES (21, 'Canon fotoaparat IXUS 160 SI', 11.990);
INSERT INTO Product (id, name, price) VALUES (22, 'Canon fotoaparat IXUS 160 WH', 11.990);
INSERT INTO Product (id, name, price) VALUES (23, 'Canon fotoaparat IXUS 170 BK EU23', 21.990);
INSERT INTO Product (id, name, price) VALUES (24, 'Canon fotoaparat IXUS 170 BL EU23', 21.990);
INSERT INTO Product (id, name, price) VALUES (25, 'Canon fotoaparat IXUS 170 SI EU23', 21.990);

INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 1, 3);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 1, 5);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 2, 1, 20);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 2, 4);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 3, 15);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 3, 4, 12);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 4, 11);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 2, 5, 17);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 6, 1);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 3, 7, 22);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 7, 21);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 4, 8, 2);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 9, 7);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 2, 10, 10);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 10, 7);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 11, 25);
INSERT INTO ShoppingCartItem (id, count, User_id, Product_id) VALUES (NULL, 1, 11, 5);


-- Select all users together with their address --
SELECT User.first_name as name, User.last_name as surname, User.email,Country.name as Country, Place.name as City, Address.street as street, Address.number as number FROM User
	JOIN Address ON User.Address_id = Address.id
    JOIN Place ON Address.Place_id = Place.id
    JOIN Country ON Place.Country_id = Country.id
    ORDER BY Country, City, name, surname;
    
-- Select all products a user with a given id bought --
SELECT Product.name, User.first_name FROM Product
	JOIN ShoppingCartItem ON ShoppingCartItem.Product_id = Product.id
    JOIN User ON User.id = ShoppingCartItem.user_id
    WHERE User.id = 1;
    
-- Select all products purchused by customers from Serbia --
SELECT Product.name, User.first_name FROM Product
		JOIN ShoppingCartItem ON ShoppingCartItem.Product_id = Product.id
		JOIN User ON User.id = ShoppingCartItem.user_id
        JOIN Address ON User.address_id = Address.id
        JOIN Place ON Address.Place_id = Place.id
        JOIN Country ON Country.id = Place.country_id
        WHERE Country.code = "rs";
    
-- Select all users from switzerland who bought at least one product --
SELECT User.first_name, User.last_name FROM User
	JOIN Address ON User.Address_id = Address.id
    JOIN Place ON Address.Place_id = Place.id
    JOIN Country ON Place.Country_id = Country.id
    JOIN ShoppingCartItem ON ShoppingCartItem.user_id = User.id
    JOIN Product ON ShoppingCartItem.Product_id = Product.id
    WHERE Country.code = "ch"
    GROUP BY User.first_name;
    
-- Select all users and display them ordered by the amount of products they bought --
SELECT User.first_name, User.last_name, COUNT(ShoppingCartItem.count) FROM User
    JOIN ShoppingCartItem ON ShoppingCartItem.user_id = User.id
     GROUP BY User.first_name, User.last_name
    ORDER BY COUNT(ShoppingCartItem.count);
    
-- Select all users whos address don't have a city --
SELECT User.first_name FROM User
	JOIN Address ON Address.id = User.address_id
    WHERE Address.place_id IS NULL;
    
-- Select all users that didn't buy a single product --
SELECT User.first_name FROM User
	LEFT JOIN ShoppingCartItem ON ShoppingCartItem.user_id = User.id
    WHERE ShoppingCartItem.count IS NULL
    ORDER BY User.first_name;
    
-- Select all products that no one bought --
SELECT Product.name FROM Product
	LEFT JOIN ShoppingCartItem ON Product.id = ShoppingCartItem.Product_id
    WHERE ShoppingCartItem.Product_id IS NULL;
    
-- Sort countries by the amount of bought items --
SELECT Country.name, COUNT(ShoppingCartItem.count) FROM Country
	JOIN Place ON Place.Country_id = Country.id
    JOIN Address ON Address.place_id = Place.id
    JOIN User ON User.Address_id = Address.id
    JOIN ShoppingCartItem ON ShoppingCartItem.User_id = User.id
    JOIN Product ON Product.id = ShoppingCartItem.Product_id
    GROUP BY Country.name
    ORDER BY COUNT(ShoppingCartItem.count) DESC;

-- Sort countries by the number of citizens --
SELECT Country.name, COUNT(User.Id) FROM Country
	JOIN Place ON Place.Country_id = Country.id
    JOIN Address ON Address.place_id = Place.id
    JOIN User ON User.Address_id = Address.id
    GROUP BY Country.name
    ORDER BY COUNT(User.Id) DESC;
    
-- Sort countries by revenue --
SELECT Country.name, SUM(ShoppingCartItem.count * Product.price) FROM Country
	JOIN Place ON Place.Country_id = Country.id
    JOIN Address ON Address.place_id = Place.id
    JOIN User ON User.Address_id = Address.id
    JOIN ShoppingCartItem ON ShoppingCartItem.User_id = User.id
    JOIN Product ON Product.id = ShoppingCartItem.Product_id
    GROUP BY Country.name
    ORDER BY SUM(ShoppingCartItem.count * Product.price) DESC;