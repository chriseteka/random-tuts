CREATE TABLE cats(
	cat_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100),
	breed VARCHAR(100),
	age INT
);
DESC cats;
INSERT INTO cats(name, breed, age) 
VALUES ('Ringo', 'Tabby', 4),
       ('Cindy', 'Maine Coon', 10),
       ('Dumbledore', 'Maine Coon', 11),
       ('Egg', 'Persian', 4),
       ('Misty', 'Tabby', 13),
       ('George Michael', 'Ragdoll', 9),
       ('Jackson', 'Sphynx', 7);
SELECT * FROM cats;

-- SELECT, UPDATE AND DELETE EXPRESSIONS

-- FETCHING COLUMN(S) OF CHOICE, WITH ANY ORDER OF CHOICE
SELECT name FROM cats;
SELECT age FROM cats;
SELECT cat_id FROM cats;
SELECT name, breed FROM cats;
SELECT breed, name, age FROM cats;

-- FETCHING WITH THE WHERE CLAUSE (AN IMPORTANT CLAUSE)
-- NB: Fetching is case insensitive.
SELECT * FROM cats WHERE age = 4;
SELECT * FROM cats WHERE name = "Egg";
SELECT name, age FROM cats WHERE breed = "Tabby";
SELECT cat_id, age FROM cats WHERE cat_id = age;
-- ALIASES (USE OF AS), use quotes if you want spaces
SELECT cat_id AS id, name AS cat_name FROM cats;
SELECT name AS 'Cat Name' FROM cats;

-- UPDATING DATA
-- Please select the data you want to update before you alter the data
UPDATE cats SET breed = "shorthair"
WHERE (breed = "Tabby" AND cat_id <> 0);

UPDATE cats SET age = 14
WHERE (name = "Misty" AND cat_id <> 0);

UPDATE cats SET name = "Jack"
WHERE (name = "Jackson" AND cat_id <> 0);

UPDATE cats SET breed = "British Shorthair"
WHERE (name = "Ringo" AND cat_id <> 0);

UPDATE cats SET age = 12
WHERE (breed = "Maine Coon" AND cat_id <> 0);

-- DELETE STATEMENTS
-- Before deleting, do a select to be sure of what you are about to delete
DELETE FROM cats WHERE (name = 'Egg' AND cat_id <> 0);
DELETE FROM cats WHERE (age = 4 AND cat_id <> 0);
DELETE FROM cats WHERE (age = cat_id AND cat_id <> 0);
DELETE FROM cats WHERE cat_id <> 0;
