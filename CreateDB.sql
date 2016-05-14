drop schema if exists dbone;
create schema dbone;
use dbone;
create table TableOne(
	Id bigint primary key auto_increment,
	Name varchar(45));
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('1', 'Apple');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('2', 'Ball');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('3', 'Cat');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('4', 'Dog');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('5', 'Elephant');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('6', 'Fox');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('7', 'Goat');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('8', 'House');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('9', 'Icecream');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('10', 'Jug');
INSERT INTO `dbone`.`TableOne` (`Id`, `Name`) VALUES ('11', 'King');


drop schema if exists dbtwo;
create schema dbtwo;
use dbtwo;
create table TableTwo(
	Id bigint primary key auto_increment,
	Name varchar(45));
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('1', 'Apple');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('2', 'Ball');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('3', 'Cat');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('4', 'Dog');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('5', 'Elephant');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('6', 'Fox');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('7', 'Goat');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('8', 'House');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('9', 'Icecream');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('10', 'Jug');
INSERT INTO `dbtwo`.`TableTwo` (`Id`, `Name`) VALUES ('11', 'King');
