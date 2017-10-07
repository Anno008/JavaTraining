CREATE DATABASE school;
USE school;

CREATE TABLE student (
    id integer auto_increment PRIMARY KEY,
    class varchar(10) NOT NULL,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL
);

CREATE TABLE subject (
    id integer auto_increment PRIMARY KEY,
    name varchar(50) NOT NULL,
    espb integer
);

CREATE TABLE exam (
    id integer auto_increment PRIMARY KEY,
    student_id integer NOT NULL,
    subject_id integer NOT NULL,
    grade integer NOT NULL,
    FOREIGN KEY (student_id) references student(id),
    FOREIGN KEY (subject_id) references subject(id)
);

INSERT INTO student (class, name, surname) VALUES("e11", "Jack", "Sparrow");
INSERT INTO student (class, name, surname) VALUES("a21", "Jason", "Momoa");
INSERT INTO student (class, name, surname) VALUES("e11", "Emma", "Watson"); 

INSERT INTO subject (name, espb) VALUES ("Which craft", 20);
INSERT INTO subject (name, espb) VALUES ("Mathematics", 25);
INSERT INTO subject (name, espb) VALUES ("Defense against the dark arts", 30);

INSERT INTO exam (student_id, subject_id, grade) VALUES (1,3,7);
INSERT INTO exam (student_id, subject_id, grade) VALUES (3,1,9);
INSERT INTO exam (student_id, subject_id, grade) VALUES (3,3,10);
INSERT INTO exam (student_id, subject_id, grade) VALUES (2,1,7);

