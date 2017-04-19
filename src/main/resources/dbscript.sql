/**
 * Create datadase and tables
 */

CREATE DATABASE employees;

USE `employees`;


CREATE TABLE IF NOT EXISTS `employees`.`organization` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `employees`.`person` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) CHARACTER SET 'big5' NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_person` (`name`, `surname`, `middle_name`, `age`)
)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `employees`.`post` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `employees`.`employee` (
  `organization_id` INT(11) NOT NULL,
  `post_id` INT(11) NOT NULL,
  `person_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  INDEX `fk_employees_post1_idx` (`post_id` ASC),
  INDEX `fk_employees_person1_idx` (`person_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_employee` (`organization_id`, `person_id`),
  CONSTRAINT `fk_employees_organization`
    FOREIGN KEY (`organization_id`)
    REFERENCES `employees`.`organization` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_employees_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `employees`.`person` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_employees_post1`
    FOREIGN KEY (`post_id`)
    REFERENCES `employees`.`post` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


/**
 * Solve problem with characher
 */

SET collation_connection = 'utf8_general_ci';

ALTER DATABASE employees CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE employee CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE post CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE organization CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE person CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;


/**
 * Insert data
 */
 
insert into organization (name) values ('ПрофВояж'),('ЗагранЭкстрим'),('Сувенир tur'),('Загранка'),('СтандартТрэвэл'),('ЭкоТранзит'),('ВояжВсемъ'),('Путевочка'),('ЛюксВояж'),('ТурДеМир');

insert into post (name) values ('директор турагентства'),('главный бухгалтер'),('менеджер по бронированию и продажам'),('менеджер по визовому обеспечению'),('менеджер по персоналу'),('администратор офиса'),('гид-переводчик'),('экскурсовод'),('агент по туризму'),('секретарь руководителя'),('оператор туристических услуг');
