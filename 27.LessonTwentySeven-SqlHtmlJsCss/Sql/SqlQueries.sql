CREATE DATABASE Test;
USE Test;

CREATE TABLE knjiga (
  id INT NOT NULL,
  naziv VARCHAR(45) NOT NULL,
  zanr VARCHAR(45) NULL,
  PRIMARY KEY (id));


CREATE TABLE autor (
  id INT NOT NULL,
  ime VARCHAR(45) NOT NULL,
  prezime VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE autorknjige (
  id INT NOT NULL AUTO_INCREMENT,
  knjiga_id INT NOT NULL,
  autor_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (knjiga_id) REFERENCES knjiga (id),
  FOREIGN KEY (autor_id) REFERENCES autor(id));

insert into knjiga (id, naziv, zanr) values (1, 'Na Drini cuprija', 'Klasici');
insert into knjiga (id, naziv, zanr) values (2, 'Maja - pricice za cvrst san', 'Knjige za decu');
insert into knjiga (id, naziv, zanr) values (3, 'Nauci da programiras', 'Knjige za decu');
insert into knjiga (id, naziv, zanr) values (4, 'Velicanstvena knjiga o zivotinjama', 'Knjige za decu');
insert into knjiga (id, naziv, zanr) values (5, 'Sta Evropa zeli?', 'Filozofija');
insert into knjiga (id, naziv, zanr) values (6, 'Biblija', 'Religija');

insert into autor (id, ime, prezime) values (1, 'Ivo', 'Andric');
insert into autor (id, ime, prezime) values (2, 'Srecko', 'Horvat');
insert into autor (id, ime, prezime) values (3, 'Zilber', 'Delae');
insert into autor (id, ime, prezime) values (4, 'Marsel', 'Marlije');
insert into autor (id, ime, prezime) values (5, 'Maks', 'Vejnrajt');
insert into autor (id, ime, prezime) values (6, 'Tom', 'Dzekson');
insert into autor (id, ime, prezime) values (7, 'Val', 'Valercuk');
insert into autor (id, ime, prezime) values (8, 'Slavoj', 'Zizek');


insert into autorknjige (knjiga_id, autor_id) values (1, 1);
insert into autorknjige (knjiga_id, autor_id) values (2, 3);
insert into autorknjige (knjiga_id, autor_id) values (2, 4);
insert into autorknjige (knjiga_id, autor_id) values (3, 5);
insert into autorknjige (knjiga_id, autor_id) values (4, 6);
insert into autorknjige (knjiga_id, autor_id) values (4, 7);
insert into autorknjige (knjiga_id, autor_id) values (5, 2);
insert into autorknjige (knjiga_id, autor_id) values (5, 8);

-- Select all books --
SELECT * FROM knjiga;

-- Display all authors whose surname starts with the letter A, then sort them by surname --
SELECT * From autor 
WHERE prezime LIKE "A%" 
ORDER BY prezime;

-- Display all books with their authors --
SELECT knjiga.naziv, autor.ime FROM autorknjige
INNER JOIN autor ON autorknjige.autor_id = autor.id
INNER JOIN knjiga ON autorknjige.knjiga_id = knjiga.id;

-- Display all books that don't have an author --
SELECT knjiga.naziv FROM knjiga
LEFT JOIN autorknjige ON autorknjige.knjiga_id = knjiga.id
WHERE autorKnjige.autor_id IS NULL;

-- For each display the number of authors that wrote it --
SELECT knjiga.naziv as Name, COUNT(autorknjige.autor_id) as NumberOfAuthors FROM autorknjige
INNER JOIN autor ON autorknjige.autor_id = autor.id
INNER JOIN knjiga ON autorknjige.knjiga_id = knjiga.id
GROUP BY knjiga.naziv;

-- Display authors that wrote books for children --
SELECT autor.ime, knjiga.naziv FROM autorknjige
INNER JOIN autor ON autorknjige.autor_id = autor.id
INNER JOIN knjiga ON autorknjige.knjiga_id = knjiga.id
WHERE knjiga.zanr = "Knjige za decu";

						
