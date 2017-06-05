CREATE DATABASE World;

USE World;

CREATE TABLE Country(
	CountryCode CHAR(2) PRIMARY KEY,
    Name VARCHAR(100),
    Population INTEGER
);

CREATE TABLE City(
	Name VARCHAR(100),
    ZipCode INTEGER UNIQUE,
    CountryCode CHAR(2),
    FOREIGN KEY(CountryCode) REFERENCES Country(CountryCode)
);

INSERT INTO Country (CountryCode,Name,Population) VALUES ("SR","Serbia",7164000);
INSERT INTO Country (CountryCode,Name,Population) VALUES ("HU","Hungary",9897000);
INSERT INTO Country (CountryCode,Name,Population) VALUES ("IT","Italia",59830000);
INSERT INTO Country (CountryCode,Name,Population) VALUES ("GR","Greece",11030000);
INSERT INTO Country (CountryCode,Name,Population) VALUES ("PO","Poland",38530000);

SELECT * FROM Country;

SELECT * FROM Country WHERE Population > 15000000;

SELECT * FROM Country ORDER BY Name;

SELECT * FROM Country WHERE Population < 20000000 AND Population > 10000000;

SELECT * FROM Country WHERE Name LIKE "%r%";

UPDATE Country SET Population = 7165000 WHERE CountryCode = "HU";

DELETE FROM Country WHERE CountryCode = "PO";

ALTER TABLE Country MODIFY Name NVARCHAR(100) NOT NULL;

SELECT * FROM Country WHERE LEFT(Name,2) = CountryCode;

INSERT INTO City (Name,ZipCode,CountryCode) VALUES ("Belgrade",11000,"SR");
INSERT INTO City (Name,ZipCode,CountryCode) VALUES ("Novi Sad",21000,"SR");
INSERT INTO City (Name,ZipCode,CountryCode) VALUES ("Athens",30601,"GR");
INSERT INTO City (Name,ZipCode,CountryCode) VALUES ("Solun",54642,"GR");
INSERT INTO City (Name,ZipCode,CountryCode) VALUES ("Rome",30149,"IT");
INSERT INTO CITY (Name,ZipCode) VALUES ("Madrid",10013);

SELECT * FROM City WHERE CountryCode = "GR";

SELECT * FROM City WHERE CountryCode = NULL;

SELECT * FROM City WHERE CountryCode IS NOT NULL ORDER BY CountryCode DESC;

SELECT * FROM City WHERE CountryCode IN(SELECT CountryCode FROM Country WHERe Population > 10000000);