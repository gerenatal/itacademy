-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema S201exercici1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema S201exercici1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `S201exercici1` DEFAULT CHARACTER SET utf8 ;
USE `S201exercici1` ;

-- -----------------------------------------------------
-- Table `S201exercici1`.`Direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici1`.`Direccion` (
  `Direccion_id` INT NOT NULL AUTO_INCREMENT,
  `Calle` VARCHAR(45) NOT NULL,
  `Numero` INT(4) NOT NULL,
  `Piso` INT(4) NULL,
  `Puerta` INT(4) NULL,
  `Ciudad` VARCHAR(45) NOT NULL,
  `Codigo_postal` VARCHAR(10) NOT NULL,
  `Pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Direccion_id`),
  UNIQUE INDEX `Direccion_id_UNIQUE` (`Direccion_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici1`.`Provedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici1`.`Provedor` (
  `Provedor_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Num_Tel` INT(9) NOT NULL,
  `Fax` INT(9) NULL,
  `NIF` VARCHAR(9) NOT NULL,
  `Direccion_Direccion_id` INT NOT NULL,
  PRIMARY KEY (`Provedor_id`),
  UNIQUE INDEX `idProvedor_UNIQUE` (`Provedor_id` ASC) VISIBLE,
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC) VISIBLE,
  UNIQUE INDEX `NIF_UNIQUE` (`NIF` ASC) VISIBLE,
  INDEX `fk_Provedor_Direccion1_idx` (`Direccion_Direccion_id` ASC) VISIBLE,
  CONSTRAINT `fk_Provedor_Direccion1`
    FOREIGN KEY (`Direccion_Direccion_id`)
    REFERENCES `S201exercici1`.`Direccion` (`Direccion_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici1`.`Gafas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici1`.`Gafas` (
  `Gafas_id` INT NOT NULL AUTO_INCREMENT,
  `Marca` VARCHAR(45) NOT NULL,
  `Graduacion_dir` DECIMAL(2) NULL,
  `Graduacion_esq` DECIMAL(2) NULL,
  `Color_muntura` VARCHAR(45) NULL,
  `Tipus_muntura` ENUM('flotant', 'pasta', 'metallica') NULL,
  `Color_cristal` VARCHAR(45) NULL,
  `Precio` DECIMAL(2) NOT NULL,
  `Provedor_Provedor_id` INT NOT NULL,
  PRIMARY KEY (`Gafas_id`, `Provedor_Provedor_id`),
  INDEX `fk_Gafas_Provedor1_idx` (`Provedor_Provedor_id` ASC) VISIBLE,
  CONSTRAINT `fk_Gafas_Provedor1`
    FOREIGN KEY (`Provedor_Provedor_id`)
    REFERENCES `S201exercici1`.`Provedor` (`Provedor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici1`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici1`.`Cliente` (
  `Cliente_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Movil` INT(9) NOT NULL,
  `correo_electronico` VARCHAR(45) NULL,
  `fecha_registro` DATE NOT NULL,
  `Cliente_Cliente_id` INT NOT NULL,
  `Direccion_Direccion_id` INT NOT NULL,
  PRIMARY KEY (`Cliente_id`),
  UNIQUE INDEX `Cliente_id_UNIQUE` (`Cliente_id` ASC) VISIBLE,
  INDEX `fk_Cliente_Cliente1_idx` (`Cliente_Cliente_id` ASC) VISIBLE,
  INDEX `fk_Cliente_Direccion1_idx` (`Direccion_Direccion_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_Cliente1`
    FOREIGN KEY (`Cliente_Cliente_id`)
    REFERENCES `S201exercici1`.`Cliente` (`Cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_Direccion1`
    FOREIGN KEY (`Direccion_Direccion_id`)
    REFERENCES `S201exercici1`.`Direccion` (`Direccion_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici1`.`Dependiente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici1`.`Dependiente` (
  `Dependiente_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Dependiente_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici1`.`Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici1`.`Venta` (
  `Venta_id` INT NOT NULL AUTO_INCREMENT,
  `Dependiente_Dependiente_id` INT NOT NULL,
  `Cliente_Cliente_id` INT NOT NULL,
  PRIMARY KEY (`Venta_id`, `Cliente_Cliente_id`),
  UNIQUE INDEX `Venta_id_UNIQUE` (`Venta_id` ASC) VISIBLE,
  INDEX `fk_Venta_Dependiente1_idx` (`Dependiente_Dependiente_id` ASC) VISIBLE,
  INDEX `fk_Venta_Cliente1_idx` (`Cliente_Cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_Venta_Dependiente1`
    FOREIGN KEY (`Dependiente_Dependiente_id`)
    REFERENCES `S201exercici1`.`Dependiente` (`Dependiente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Cliente1`
    FOREIGN KEY (`Cliente_Cliente_id`)
    REFERENCES `S201exercici1`.`Cliente` (`Cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici1`.`Gafas_has_Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici1`.`Gafas_has_Venta` (
  `Gafas_Gafas_id` INT NOT NULL,
  `Gafas_Provedor_Provedor_id` INT NOT NULL,
  `Venta_Venta_id` INT NOT NULL,
  PRIMARY KEY (`Gafas_Gafas_id`, `Gafas_Provedor_Provedor_id`, `Venta_Venta_id`),
  INDEX `fk_Gafas_has_Venta_Venta1_idx` (`Venta_Venta_id` ASC) VISIBLE,
  INDEX `fk_Gafas_has_Venta_Gafas1_idx` (`Gafas_Gafas_id` ASC, `Gafas_Provedor_Provedor_id` ASC) VISIBLE,
  CONSTRAINT `fk_Gafas_has_Venta_Gafas1`
    FOREIGN KEY (`Gafas_Gafas_id` , `Gafas_Provedor_Provedor_id`)
    REFERENCES `S201exercici1`.`Gafas` (`Gafas_id` , `Provedor_Provedor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gafas_has_Venta_Venta1`
    FOREIGN KEY (`Venta_Venta_id`)
    REFERENCES `S201exercici1`.`Venta` (`Venta_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
