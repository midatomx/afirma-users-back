CREATE DATABASE afirma;

USE afirma;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema afirma
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema afirma
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `afirma` DEFAULT CHARACTER SET utf8;
USE `afirma`;

-- -----------------------------------------------------
-- Table `afirma`.`afirma_c_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `afirma`.`afirma_c_usuarios`
(
    `id`                 INT          NOT NULL AUTO_INCREMENT,
    `nombre`             VARCHAR(100) NOT NULL,
    `apellido`           VARCHAR(100) NOT NULL,
    `correo_electrónico` VARCHAR(100) NOT NULL,
    `fecha_nacimiento`   TIMESTAMP    NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
