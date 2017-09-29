DROP DATABASE  IF EXISTS country_place;
CREATE DATABASE country_place;

USE country_place;

CREATE TABLE country (
	id integer auto_increment,
    name varchar(100) not null,
    population int,
    primary key (id)
);

CREATE TABLE city (
	id integer auto_increment,
    name varchar(100) not null,
    country_id integer,
    foreign key (country_id) references country(id),
    primary key (id)
);

INSERT INTO country (name, population) VALUES("Serbia",7000000);
INSERT INTO country (name, population) VALUES("Netherlands", 17000000);
INSERT INTO country (name, population) VALUES("Austria", 8700000);

INSERT INTO city (name, country_id) SELECT "Novi Sad", country.id FROM country WHERE country.name = "Serbia";
INSERT INTO city (name, country_id) SELECT "Subotica", country.id FROM country WHERE country.name = "Serbia";
INSERT INTO city (name, country_id) SELECT "Belgrade", country.id FROM country WHERE country.name = "Serbia";
INSERT INTO city (name, country_id) SELECT "Amstermdam", country.id FROM country WHERE country.name = "Netherlands";
INSERT INTO city (name, country_id) SELECT "The Hague", country.id FROM country WHERE country.name = "Netherlands";
INSERT INTO city (name, country_id) SELECT "Rotterdam", country.id FROM country WHERE country.name = "Netherlands";
INSERT INTO city (name, country_id) SELECT "Vienna", country.id FROM country WHERE country.name = "Austria";
INSERT INTO city (name, country_id) SELECT "Graz", country.id FROM country WHERE country.name = "Austria";
INSERT INTO city (name, country_id) SELECT "Linz", country.id FROM country WHERE country.name = "Austria";
