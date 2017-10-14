
DROP DATABASE IF EXISTS school;
CREATE DATABASE school;
USE school;

-- Don't really need this since I am droping the whole db anyways
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `subject`;
DROP TABLE IF EXISTS `exam`;
DROP TABLE IF EXISTS `security_user`;
DROP TABLE IF EXISTS `security_authority`;
DROP TABLE IF EXISTS `security_user_authority`;

CREATE TABLE student (
    id integer auto_increment PRIMARY KEY,
    card varchar(10) NOT NULL,
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

CREATE TABLE security_user (
    id int auto_increment PRIMARY KEY,
    username varchar(200) NOT NULL,
    password varchar(200) NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL
);

CREATE TABLE security_authority (
    id integer auto_increment PRIMARY KEY,
    name varchar(50) NOT NULL
);

CREATE TABLE security_user_authority (
    id integer auto_increment PRIMARY KEY,
    user_id integer NOT NULL,
    authority_id integer NOT NULL,
    FOREIGN KEY (user_id) references security_user(id),
    FOREIGN KEY (authority_id) references security_authority(id)
);

-- username = admin, password = 12345
INSERT INTO security_user (username, password, first_name, last_name) VALUES ("admin", "$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi", "admin", "admin");
-- username = user, password = abcdef
INSERT INTO security_user (username, password, first_name, last_name) VALUES ("user", "$2a$04$Yr3QD6lbcemnrRNLbUMLBez2oEK15pdacIgfkvymQ9oMhqsEE56EK", "user", "user");

INSERT INTO security_authority (name) VALUES ("ROLE_ADMIN");
INSERT INTO security_authority (name) VALUES ("ROLE_USER");

INSERT INTO security_user_authority (user_id, authority_id) VALUES (1,1);
INSERT INTO security_user_authority (user_id, authority_id) VALUES (1,2);
INSERT INTO security_user_authority (user_id, authority_id) VALUES (2,2);

INSERT INTO student (card, name, surname) VALUES("e11", "Jack", "Sparrow");
INSERT INTO student (card, name, surname) VALUES("a21", "Jason", "Momoa");
INSERT INTO student (card, name, surname) VALUES("e11", "Emma", "Watson"); 

INSERT INTO subject (name, espb) VALUES ("Which craft", 20);
INSERT INTO subject (name, espb) VALUES ("Mathematics", 25);
INSERT INTO subject (name, espb) VALUES ("Defense against the dark arts", 30);

INSERT INTO exam (student_id, subject_id, grade) VALUES (1,3,7);
INSERT INTO exam (student_id, subject_id, grade) VALUES (3,1,9);
INSERT INTO exam (student_id, subject_id, grade) VALUES (3,3,10);
INSERT INTO exam (student_id, subject_id, grade) VALUES (2,1,7);

