-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Tim`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tim` (
  `TimId` INT NOT NULL,
  `NazivTima` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`TimId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stadion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Stadion` (
  `StadionId` INT NOT NULL,
  `NazivStadiona` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`StadionId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Utakmica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Utakmica` (
  `UtakmicaId` INT NOT NULL,
  `Rezultat` VARCHAR(45) NOT NULL,
  `Stadion_StadionId` INT NOT NULL,
  `Tim1` INT NOT NULL,
  `Tim2` INT NOT NULL,
  PRIMARY KEY (`UtakmicaId`),
  INDEX `fk_Utakmica_Stadion_idx` (`Stadion_StadionId` ASC),
  INDEX `fk_Utakmica_Tim1_idx` (`Tim1` ASC),
  INDEX `fk_Utakmica_Tim2_idx` (`Tim2` ASC),
  CONSTRAINT `fk_Utakmica_Stadion`
    FOREIGN KEY (`Stadion_StadionId`)
    REFERENCES `mydb`.`Stadion` (`StadionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Utakmica_Tim1`
    FOREIGN KEY (`Tim1`)
    REFERENCES `mydb`.`Tim` (`TimId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Utakmica_Tim2`
    FOREIGN KEY (`Tim2`)
    REFERENCES `mydb`.`Tim` (`TimId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

