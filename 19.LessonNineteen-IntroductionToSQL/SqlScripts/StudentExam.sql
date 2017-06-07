CREATE DATABASE School;

USE School;

CREATE TABLE Student(
	StudentIndex INTEGER PRIMARY KEY,
	Name VARCHAR(100) NOT NULL,
    Surname VARCHAR(100) NOT NULL
);

CREATE TABLE Subject(
	SubjectId INTEGER PRIMARY KEY auto_increment,
    Name VARCHAR(100) NOT NULL
);

CREATE TABLE Exam(
	ExamId INTEGER PRIMARY KEY auto_increment,
    Grade INTEGER NOT NULL,
    StudentIndex INTEGER,
    SubjectId INTEGER,
    FOREIGN KEY (StudentIndex) REFERENCES Student(StudentIndex),
    FOREIGN KEY (SubjectId) REFERENCES Subject(SubjectId)
);