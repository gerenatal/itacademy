-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema S201exercici2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema S201exercici2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `S201exercici2` DEFAULT CHARACTER SET utf8 ;
USE `S201exercici2` ;

-- -----------------------------------------------------
-- Table `S201exercici2`.`Provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Provincia` (
  `Provincia_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Provincia_id`),
  UNIQUE INDEX `Provincia_id_UNIQUE` (`Provincia_id` ASC) VISIBLE,
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Localidad` (
  `Localidad_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Provincia_Provincia_id` INT NOT NULL,
  PRIMARY KEY (`Localidad_id`, `Provincia_Provincia_id`),
  UNIQUE INDEX `Localidad_id_UNIQUE` (`Localidad_id` ASC) VISIBLE,
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC) VISIBLE,
  INDEX `fk_Localidad_Provincia_idx` (`Provincia_Provincia_id` ASC) VISIBLE,
  CONSTRAINT `fk_Localidad_Provincia`
    FOREIGN KEY (`Provincia_Provincia_id`)
    REFERENCES `S201exercici2`.`Provincia` (`Provincia_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Cliente` (
  `Cliente_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(90) NOT NULL,
  `Codigo_postal` INT(5) NOT NULL,
  `Movil` INT(9) NOT NULL,
  `Localidad_Localidad_id` INT NOT NULL,
  `Localidad_Provincia_Provincia_id` INT NOT NULL,
  PRIMARY KEY (`Cliente_id`, `Localidad_Localidad_id`, `Localidad_Provincia_Provincia_id`),
  UNIQUE INDEX `Cliente_id_UNIQUE` (`Cliente_id` ASC) VISIBLE,
  INDEX `fk_Cliente_Localidad1_idx` (`Localidad_Localidad_id` ASC, `Localidad_Provincia_Provincia_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_Localidad1`
    FOREIGN KEY (`Localidad_Localidad_id` , `Localidad_Provincia_Provincia_id`)
    REFERENCES `S201exercici2`.`Localidad` (`Localidad_id` , `Provincia_Provincia_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Tienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Tienda` (
  `Tienda_id` INT NOT NULL AUTO_INCREMENT,
  `Direccion` VARCHAR(90) NOT NULL,
  `Codigo_postal` INT(5) NOT NULL,
  `Localidad_Localidad_id` INT NOT NULL,
  `Localidad_Provincia_Provincia_id` INT NOT NULL,
  PRIMARY KEY (`Tienda_id`, `Localidad_Localidad_id`, `Localidad_Provincia_Provincia_id`),
  UNIQUE INDEX `Tienda_id_UNIQUE` (`Tienda_id` ASC) VISIBLE,
  INDEX `fk_Tienda_Localidad1_idx` (`Localidad_Localidad_id` ASC, `Localidad_Provincia_Provincia_id` ASC) VISIBLE,
  CONSTRAINT `fk_Tienda_Localidad1`
    FOREIGN KEY (`Localidad_Localidad_id` , `Localidad_Provincia_Provincia_id`)
    REFERENCES `S201exercici2`.`Localidad` (`Localidad_id` , `Provincia_Provincia_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Productos` (
  `Productos_id` INT NOT NULL AUTO_INCREMENT,
  UNIQUE INDEX `idProductos_UNIQUE` (`Productos_id` ASC) VISIBLE,
  PRIMARY KEY (`Productos_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Dependiente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Dependiente` (
  `Dependiente_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `NIF` VARCHAR(9) NOT NULL,
  `Movil` INT(9) NOT NULL,
  `Tarea` ENUM('cocina', 'entrega') NOT NULL,
  `Tienda_Tienda_id` INT NOT NULL,
  PRIMARY KEY (`Dependiente_id`),
  UNIQUE INDEX `Dependiente_id_UNIQUE` (`Dependiente_id` ASC) VISIBLE,
  UNIQUE INDEX `NIF_UNIQUE` (`NIF` ASC) VISIBLE,
  INDEX `fk_Dependiente_Tienda1_idx` (`Tienda_Tienda_id` ASC) VISIBLE,
  CONSTRAINT `fk_Dependiente_Tienda1`
    FOREIGN KEY (`Tienda_Tienda_id`)
    REFERENCES `S201exercici2`.`Tienda` (`Tienda_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Entrega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Entrega` (
  `Entrega_id` INT NOT NULL,
  `Dependiente_Dependiente_id` INT NOT NULL,
  `Fecha_entrega` DATETIME NOT NULL,
  PRIMARY KEY (`Entrega_id`, `Dependiente_Dependiente_id`),
  INDEX `fk_Entrega_Dependiente1_idx` (`Dependiente_Dependiente_id` ASC) VISIBLE,
  CONSTRAINT `fk_Entrega_Dependiente1`
    FOREIGN KEY (`Dependiente_Dependiente_id`)
    REFERENCES `S201exercici2`.`Dependiente` (`Dependiente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Pedido` (
  `Pedido_id` INT NOT NULL AUTO_INCREMENT,
  `Cliente_Cliente_id` INT NOT NULL,
  `Servicio` ENUM('entrega', 'recogida') NOT NULL,
  `Cantidad_produtos` INT(2) NOT NULL,
  `Precio_total` DECIMAL(3,2) NOT NULL,
  `Fecha_hora` DATETIME NOT NULL,
  `Tienda_Tienda_id` INT NOT NULL,
  `Tienda_Localidad_Localidad_id` INT NOT NULL,
  `Tienda_Localidad_Provincia_Provincia_id` INT NOT NULL,
  `Productos_Productos_id` INT NOT NULL,
  `Entrega_Entrega_id` INT NOT NULL,
  `Entrega_Dependiente_Dependiente_id` INT NOT NULL,
  PRIMARY KEY (`Pedido_id`, `Cliente_Cliente_id`),
  UNIQUE INDEX `Pedido_id_UNIQUE` (`Pedido_id` ASC) VISIBLE,
  INDEX `fk_Pedido_Cliente1_idx` (`Cliente_Cliente_id` ASC) VISIBLE,
  INDEX `fk_Pedido_Tienda1_idx` (`Tienda_Tienda_id` ASC, `Tienda_Localidad_Localidad_id` ASC, `Tienda_Localidad_Provincia_Provincia_id` ASC) VISIBLE,
  INDEX `fk_Pedido_Productos1_idx` (`Productos_Productos_id` ASC) VISIBLE,
  INDEX `fk_Pedido_Entrega1_idx` (`Entrega_Entrega_id` ASC, `Entrega_Dependiente_Dependiente_id` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_Cliente_id`)
    REFERENCES `S201exercici2`.`Cliente` (`Cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Tienda1`
    FOREIGN KEY (`Tienda_Tienda_id` , `Tienda_Localidad_Localidad_id` , `Tienda_Localidad_Provincia_Provincia_id`)
    REFERENCES `S201exercici2`.`Tienda` (`Tienda_id` , `Localidad_Localidad_id` , `Localidad_Provincia_Provincia_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Productos1`
    FOREIGN KEY (`Productos_Productos_id`)
    REFERENCES `S201exercici2`.`Productos` (`Productos_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Entrega1`
    FOREIGN KEY (`Entrega_Entrega_id` , `Entrega_Dependiente_Dependiente_id`)
    REFERENCES `S201exercici2`.`Entrega` (`Entrega_id` , `Dependiente_Dependiente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Categoria` (
  `Categoria_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Categoria_id`),
  UNIQUE INDEX `Categoria_id_UNIQUE` (`Categoria_id` ASC) VISIBLE,
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Pizza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Pizza` (
  `Pizza_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(90) NULL,
  `Imagen` MEDIUMBLOB NULL,
  `Precio` DECIMAL(3,2) NOT NULL,
  `Categoria_Categoria_id` INT NOT NULL,
  PRIMARY KEY (`Pizza_id`, `Categoria_Categoria_id`),
  UNIQUE INDEX `Pizza_id_UNIQUE` (`Pizza_id` ASC) VISIBLE,
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC) VISIBLE,
  INDEX `fk_Pizza_Categoria1_idx` (`Categoria_Categoria_id` ASC) VISIBLE,
  CONSTRAINT `fk_Pizza_Categoria1`
    FOREIGN KEY (`Categoria_Categoria_id`)
    REFERENCES `S201exercici2`.`Categoria` (`Categoria_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Hamburguesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Hamburguesa` (
  `Hamburguesa_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(90) NULL,
  `Imagen` MEDIUMBLOB NULL,
  `Precio` DECIMAL(3,2) NOT NULL,
  PRIMARY KEY (`Hamburguesa_id`),
  UNIQUE INDEX `Hamburguesas_id_UNIQUE` (`Hamburguesa_id` ASC) VISIBLE,
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Bebida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Bebida` (
  `Bebida_id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(90) NULL,
  `Imagen` MEDIUMBLOB NULL,
  `Precio` DECIMAL(3,2) NOT NULL,
  PRIMARY KEY (`Bebida_id`),
  UNIQUE INDEX `Bebidas_id_UNIQUE` (`Bebida_id` ASC) VISIBLE,
  UNIQUE INDEX `Nombre_UNIQUE` (`Nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Productos_has_Pizza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Productos_has_Pizza` (
  `Productos_Productos_id` INT NOT NULL,
  `Pizza_Pizza_id` INT NOT NULL,
  `Pizza_Categoria_Categoria_id` INT NOT NULL,
  PRIMARY KEY (`Productos_Productos_id`, `Pizza_Pizza_id`, `Pizza_Categoria_Categoria_id`),
  INDEX `fk_Productos_has_Pizza_Pizza1_idx` (`Pizza_Pizza_id` ASC, `Pizza_Categoria_Categoria_id` ASC) VISIBLE,
  INDEX `fk_Productos_has_Pizza_Productos1_idx` (`Productos_Productos_id` ASC) VISIBLE,
  CONSTRAINT `fk_Productos_has_Pizza_Productos1`
    FOREIGN KEY (`Productos_Productos_id`)
    REFERENCES `S201exercici2`.`Productos` (`Productos_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_has_Pizza_Pizza1`
    FOREIGN KEY (`Pizza_Pizza_id` , `Pizza_Categoria_Categoria_id`)
    REFERENCES `S201exercici2`.`Pizza` (`Pizza_id` , `Categoria_Categoria_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Productos_has_Hamburguesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Productos_has_Hamburguesa` (
  `Productos_Productos_id` INT NOT NULL,
  `Hamburguesa_Hamburguesa_id` INT NOT NULL,
  PRIMARY KEY (`Productos_Productos_id`, `Hamburguesa_Hamburguesa_id`),
  INDEX `fk_Productos_has_Hamburguesa_Hamburguesa1_idx` (`Hamburguesa_Hamburguesa_id` ASC) VISIBLE,
  INDEX `fk_Productos_has_Hamburguesa_Productos1_idx` (`Productos_Productos_id` ASC) VISIBLE,
  CONSTRAINT `fk_Productos_has_Hamburguesa_Productos1`
    FOREIGN KEY (`Productos_Productos_id`)
    REFERENCES `S201exercici2`.`Productos` (`Productos_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_has_Hamburguesa_Hamburguesa1`
    FOREIGN KEY (`Hamburguesa_Hamburguesa_id`)
    REFERENCES `S201exercici2`.`Hamburguesa` (`Hamburguesa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `S201exercici2`.`Productos_has_Bebida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `S201exercici2`.`Productos_has_Bebida` (
  `Productos_Productos_id` INT NOT NULL,
  `Bebida_Bebida_id` INT NOT NULL,
  PRIMARY KEY (`Productos_Productos_id`, `Bebida_Bebida_id`),
  INDEX `fk_Productos_has_Bebida_Bebida1_idx` (`Bebida_Bebida_id` ASC) VISIBLE,
  INDEX `fk_Productos_has_Bebida_Productos1_idx` (`Productos_Productos_id` ASC) VISIBLE,
  CONSTRAINT `fk_Productos_has_Bebida_Productos1`
    FOREIGN KEY (`Productos_Productos_id`)
    REFERENCES `S201exercici2`.`Productos` (`Productos_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_has_Bebida_Bebida1`
    FOREIGN KEY (`Bebida_Bebida_id`)
    REFERENCES `S201exercici2`.`Bebida` (`Bebida_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
