CREATE DATABASE School default character set utf8;

USE School1

CREATE TABLE Student (
	StudentId INTEGER AUTO_INCREMENT PRIMARY KEY, 
	StudentIndex VARCHAR(10) NOT NULL,
	FirstName VARCHAR(100) NOT NULL,
	LastName VARCHAR(100) NOT NULL
);

CREATE TABLE Subject(
	SubjectId INTEGER AUTO_INCREMENT PRIMARY KEY, 
	SubjectName VARCHAR(200) NOT NULL
);

CREATE TABLE Exam(
	ExamdId INTEGER AUTO_INCREMENT PRIMARY KEY, 
	StudentId INTEGER,
	SubjectId INTEGER,
	Grade INTEGER,
	FOREIGN KEY (StudentId) references Student(StudentId),
	FOREIGN KEY (SubjectId ) references Subject(SubjectId)
);

INSERT INTO Student (StudentId, StudentIndex, FirstName , LastName) VALUES (1, 'e12','Pera', 'Peric');
INSERT INTO Student (StudentId, StudentIndex, FirstName , LastName) VALUES (2, 'e15','Steva', 'Stevic');
INSERT INTO Student (StudentId, StudentIndex, FirstName , LastName) VALUES (3, 'e18','Marko', 'Markovic');
INSERT INTO Student (StudentId, StudentIndex, FirstName , LastName) VALUES (4, 'e22','Mitar', 'Mitrovic');
INSERT INTO Student (StudentId, StudentIndex, FirstName , LastName) VALUES (5, 'e25','Jovan', 'Jovanovic');

INSERT INTO Subject (SubjectId, SubjectName) VALUES (1,'Matematicka analiza');
INSERT INTO Subject (SubjectId, SubjectName) VALUES (2,'Web programiranje');
INSERT INTO Subject (SubjectId, SubjectName) VALUES (3,'Objektno orjentisano programiranje');
INSERT INTO Subject (SubjectId, SubjectName) VALUES (4,'Racunarska inteligencija');

INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (1,1,7);
INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (1,2,8);
INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (1,3,7);

INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (2,1,7);
INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (2,2,9);
INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (2,3,9);

INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (3,1,10);
INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (3,3,10);

INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (4,2,8);
INSERT INTO Exam (StudentId, SubjectId, Grade) VALUES (4,3,9);

-- Display all students together with the subjects they passed, also display students that didn't passa any exams --
SELECT * FROM Student LEFT JOIN Exam ON Student.StudentId = Exam.StudentId;

-- Display all students and sbujects, display only students that have passed a subject but display all subjects --    
SELECT Subject.SubjectName, Student.FirstName FROM Subject 
	LEFT JOIN Exam ON Subject.SubjectId = Exam.SubjectId
	LEFT JOIN Student ON Student.StudentId = Exam.StudentId
	GROUP BY Student.FirstName, Subject.SubjectName;

-- Display all students and sbujects, display only students that have passed a subject --    
SELECT Subject.SubjectName, Student.FirstName FROM Subject 
	JOIN Exam ON Subject.SubjectId = Exam.SubjectId
	JOIN Student ON Student.StudentId = Exam.StudentId
	GROUP BY Student.FirstName, Subject.SubjectName;
    
-- Display students average grade --
SELECT Student.FirstName, AVG(Exam.Grade) FROM Student
	JOIN Exam ON Student.StudentId = Exam.StudentId
    GROUP BY Student.FirstName;

-- Display subjects together with the count of how many students passed it and order it--
SELECT Subject.SubjectName, COUNT(Student.StudentId) FROM Subject
	JOIN Exam ON Subject.SubjectId = Exam.SubjectId
    JOIN Student ON Student.StudentId = Exam.StudentId
    GROUP BY Subject.SubjectName
    ORDER BY COUNT(Student.StudentId);
