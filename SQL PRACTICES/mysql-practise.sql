SHOW databases;
CREATE DATABASE practise_db;
CREATE DATABASE farm_db;
DROP DATABASE farm_db;
DROP DATABASE practise_db;
CREATE DATABASE practise_db;
USE practise_db;
USE blessed;
SELECT database();
SHOW TABLES;
CREATE TABLE cats(name VARCHAR(100), age INT); -- Always in capital letters
SHOW COLUMNS FROM cats; -- Shows the columns in a table
DESC pastries;
DROP TABLE pastries;
CREATE TABLE pastries (
	name VARCHAR (50),
	quantity INT
);


-- INSERTING TO DATABASES LESSON
SELECT database();
SHOW TABLES;
CREATE TABLE cats(name VARCHAR(50), age INT);
SHOW COLUMNS FROM cats;
INSERT INTO cats(name, age) VALUES ('JJC', 10);
INSERT INTO cats(age, name) VALUES(10, 'DRAGO');
SELECT * FROM cats;
INSERT INTO cats(name, age) VALUES ('ADA', 3), ('UGO', 4), ('JECO', 7);
CREATE TABLE people(first_name VARCHAR(20), last_name VARCHAR(20), age INT);
INSERT INTO people(first_name, last_name, age)
	VALUES ('Tina', 'Hanskel', 20);
INSERT INTO people(last_name, first_name, age)
	VALUES ('Hanskel', 'John', 22);
INSERT INTO people(first_name, last_name, age)
	VALUES ('Hurray', 'BOB', 10)
		,('Jensson', 'BOB', 17)
        ,('Freeman', 'BOB', 18);
DROP TABLE people;
SELECT * FROM people;
SHOW WARNINGS; -- SQL Command to show all warnings
SHOW TABLES;
CREATE TABLE cats2(
	name VARCHAR(100) NOT NULL
    ,age INT NOT NULL
);
INSERT INTO  cats2() VALUES ();
SELECT * FROM cats2;
DROP TABLE cats2;
CREATE TABLE cats2(
	name VARCHAR(50) NOT NULL DEFAULT 'NO NAME',
    age INT NOT NULL DEFAULT 700
);
INSERT INTO cats2(name) VALUES ('CAT NAME');
INSERT INTO cats2(age, name) VALUES (NULL, 'EATER');
INSERT INTO cats2() VALUES ();
DESC cats2;

CREATE TABLE unique_cats(
	cat_id INT NOT NULL AUTO_INCREMENT
    ,name VARCHAR(50) NOT NULL DEFAULT 'NO NAME'
    ,age INT NOT NULL DEFAULT 700
    ,PRIMARY KEY (cat_id)
);
DESC unique_cats;
DROP TABLE unique_cats;
INSERT INTO unique_cats(name, age)
	VALUES ("Killer", 22)
			,("Helper", 15);
INSERT INTO unique_cats(name, age)
	VALUES ("Nodder", 11);
SELECT * FROM unique_cats;

-- EXERCISE
CREATE TABLE Employees(
id INT NOT NULL AUTO_INCREMENT,
last_name VARCHAR(50) NOT NULL,
first_name VARCHAR(50) NOT NULL,
middle_name VARCHAR(50),
age INT NOT NULL,
current_status VARCHAR(40) NOT NULL DEFAULT 'Employed',
PRIMARY KEY (id)
);
DESC Employees;
SELECT * FROM Employees;
INSERT INTO Employees(last_name, first_name, age)
VALUES('Ugbala', 'Arinze', 22);