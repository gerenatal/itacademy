-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`clients` (
  `idclients` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  UNIQUE INDEX `idclientes_UNIQUE` (`idclients` ASC) VISIBLE,
  PRIMARY KEY (`idclients`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`delivery` (
  `iddelivery` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `available` TINYINT NULL,
  `driving` ENUM('motorcycle', 'byke', 'foot') NULL,
  PRIMARY KEY (`iddelivery`),
  UNIQUE INDEX `nombre_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `idrepartidores_UNIQUE` (`iddelivery` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`products` (
  `idproducts` INT NOT NULL AUTO_INCREMENT,
  `product` ENUM('sandwich', 'burrito', 'kebab', 'pizza') NOT NULL,
  `price` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`idproducts`),
  UNIQUE INDEX `idproducts_UNIQUE` (`idproducts` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orders` (
  `idorders` INT NOT NULL AUTO_INCREMENT,
  `lista_de_productos` VARCHAR(45) NULL,
  `repartidor` VARCHAR(45) NULL,
  `clients_idclients` INT NOT NULL,
  `delivery_iddelivery` INT NOT NULL,
  `products_idproducts` INT NOT NULL,
  `status` ENUM('ongoing', 'delivered') NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idorders`, `clients_idclients`, `delivery_iddelivery`, `products_idproducts`),
  UNIQUE INDEX `idpedidos_UNIQUE` (`idorders` ASC) VISIBLE,
  INDEX `fk_orders_clients_idx` (`clients_idclients` ASC) VISIBLE,
  INDEX `fk_orders_delivery1_idx` (`delivery_iddelivery` ASC) VISIBLE,
  INDEX `fk_orders_products1_idx` (`products_idproducts` ASC) VISIBLE,
  CONSTRAINT `fk_orders_clients`
    FOREIGN KEY (`clients_idclients`)
    REFERENCES `mydb`.`clients` (`idclients`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_delivery1`
    FOREIGN KEY (`delivery_iddelivery`)
    REFERENCES `mydb`.`delivery` (`iddelivery`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_products1`
    FOREIGN KEY (`products_idproducts`)
    REFERENCES `mydb`.`products` (`idproducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
