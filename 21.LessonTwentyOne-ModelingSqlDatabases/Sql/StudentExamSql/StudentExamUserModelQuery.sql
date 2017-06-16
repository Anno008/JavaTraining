-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema StudentsOrg
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `StudentsOrg` ;

-- -----------------------------------------------------
-- Schema StudentsOrg
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `StudentsOrg` DEFAULT CHARACTER SET utf8 ;
USE `StudentsOrg` ;

-- -----------------------------------------------------
-- Table `StudentsOrg`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`Country` (
  `CountryId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`CountryId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentsOrg`.`City`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`City` (
  `CityId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `Country_CountryId` INT NOT NULL,
  PRIMARY KEY (`CityId`),
  INDEX `fk_City_Country_idx` (`Country_CountryId` ASC),
  CONSTRAINT `fk_City_Country`
    FOREIGN KEY (`Country_CountryId`)
    REFERENCES `StudentsOrg`.`Country` (`CountryId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentsOrg`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`Student` (
  `StudentId` INT NOT NULL AUTO_INCREMENT,
  `Index` VARCHAR(45) NOT NULL,
  `Name` VARCHAR(100) NOT NULL,
  `Surname` VARCHAR(100) NOT NULL,
  `BirthDate` DATE NOT NULL,
  `City_CityId` INT NOT NULL,
  PRIMARY KEY (`StudentId`),
  INDEX `fk_Student_City1_idx` (`City_CityId` ASC),
  CONSTRAINT `fk_Student_City1`
    FOREIGN KEY (`City_CityId`)
    REFERENCES `StudentsOrg`.`City` (`CityId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentsOrg`.`Subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`Subject` (
  `SubjectId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`SubjectId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentsOrg`.`Exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`Exam` (
  `ExamId` INT NOT NULL AUTO_INCREMENT,
  `Grade` INT NOT NULL,
  `Date` DATE NOT NULL,
  `Subject_SubjectId` INT NOT NULL,
  `Student_StudentId` INT NOT NULL,
  PRIMARY KEY (`ExamId`),
  INDEX `fk_Exam_Subject1_idx` (`Subject_SubjectId` ASC),
  INDEX `fk_Exam_Student1_idx` (`Student_StudentId` ASC),
  CONSTRAINT `fk_Exam_Subject1`
    FOREIGN KEY (`Subject_SubjectId`)
    REFERENCES `StudentsOrg`.`Subject` (`SubjectId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Exam_Student1`
    FOREIGN KEY (`Student_StudentId`)
    REFERENCES `StudentsOrg`.`Student` (`StudentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentsOrg`.`WrittenVerbalExam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`WrittenVerbalExam` (
  `VerbalPoints` INT NOT NULL,
  `WrittenPoints` INT NOT NULL,
  `WrittenDate` DATE NOT NULL,
  `VerbalDate` DATE NULL,
  `WrittenVerbalExamcol` VARCHAR(45) NULL,
  `Exam_ExamId` INT NOT NULL,
  INDEX `fk_WrittenVerbalExam_Exam1_idx` (`Exam_ExamId` ASC),
  CONSTRAINT `fk_WrittenVerbalExam_Exam1`
    FOREIGN KEY (`Exam_ExamId`)
    REFERENCES `StudentsOrg`.`Exam` (`ExamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `StudentsOrg`.`ColloquiumExam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`ColloquiumExam` (
  `Exam_ExamId` INT NOT NULL,
  INDEX `fk_ColloquiumExam_Exam1_idx` (`Exam_ExamId` ASC),
  PRIMARY KEY (`Exam_ExamId`),
  CONSTRAINT `fk_ColloquiumExam_Exam1`
    FOREIGN KEY (`Exam_ExamId`)
    REFERENCES `StudentsOrg`.`Exam` (`ExamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentsOrg`.`Colloquium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`Colloquium` (
  `ColloquiumId` INT NOT NULL AUTO_INCREMENT,
  `Points` INT NOT NULL,
  `Date` DATE NOT NULL,
  `ColloquiumExam_Exam_ExamId` INT NOT NULL,
  PRIMARY KEY (`ColloquiumId`),
  INDEX `fk_Colloquium_ColloquiumExam1_idx` (`ColloquiumExam_Exam_ExamId` ASC),
  CONSTRAINT `fk_Colloquium_ColloquiumExam1`
    FOREIGN KEY (`ColloquiumExam_Exam_ExamId`)
    REFERENCES `StudentsOrg`.`ColloquiumExam` (`Exam_ExamId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentsOrg`.`UserType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`UserType` (
  `UserTypeId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`UserTypeId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentsOrg`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentsOrg`.`User` (
  `UserId` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(100) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `UserType_UserTypeId` INT NOT NULL,
  PRIMARY KEY (`UserId`),
  INDEX `fk_User_UserType1_idx` (`UserType_UserTypeId` ASC),
  CONSTRAINT `fk_User_UserType1`
    FOREIGN KEY (`UserType_UserTypeId`)
    REFERENCES `StudentsOrg`.`UserType` (`UserTypeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
