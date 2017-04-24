/**
 * Create datadase and tables
 */

CREATE USER 'admin'@'localhost' IDENTIFIED BY '1221';
GRANT ALL PRIVILEGES ON * . * TO 'admin'@'localhost';

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

insert into person (name, surname, middle_name, age) values ('Осипов', 'Ярослав', 'Митрофанович', 45), ('Буров', 'Федосей', 'Демьянович', 34),('Крылов', 'Юлиан', 'Серапионович', 37), ('Андреев', 'Александр', 'Александрович', 26), ('Аседова', 'Елизавета', 'Виталиевна', 56), ('Валинуров', 'Денис', 'Юрьевич', 30);

insert into employee (person_id, organization_id, post_id) values (1, 1, 1), (1, 2, 1), (2, 2, 3), (2, 3, 4), (3, 5, 6), (4, 6, 5), (5, 4, 2), (6, 1, 3);
