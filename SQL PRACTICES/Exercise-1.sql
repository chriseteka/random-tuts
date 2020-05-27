CREATE DATABASE shirts_db;
USE shirts_db;
SELECT database();
CREATE TABLE shirts(
	shirt_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    article VARCHAR(50) NOT NULL,
    color VARCHAR(50) NOT NULL,
    shirt_size VARCHAR(50) NOT NULL,
    last_worn INT NOT NULL
);
SHOW TABLES;
DESC shirts;
INSERT INTO shirts(article, color, shirt_size, last_worn) 
VALUES ('t-shirt', 'white', 'S', 10),
	   ('t-shirt', 'green', 'S', 200),
	   ('polo shirt', 'black', 'M', 10),
	   ('tank top', 'blue', 'S', 50),
	   ('t-shirt', 'pink', 'S', 0),
	   ('polo shirt', 'red', 'M', 5),
	   ('tank top', 'white', 'S', 200),
	   ('tank top', 'blue', 'M', 15);
INSERT INTO shirts(color, article, shirt_size, last_worn)
VALUES ('Purple', 'Polo shirt', 'M', 50);

-- SELECTS
SELECT * FROM shirts;
SELECT article, color FROM shirts;
SELECT article, color, shirt_size, last_worn FROM shirts WHERE shirt_size = 'M';

-- UPDATES
UPDATE shirts SET shirt_size = 'L'
WHERE (article = 'Polo shirt' AND shirt_id <> 0);
UPDATE shirts SET last_worn = 0
WHERE (last_worn = 15 AND shirt_id <> 0);
UPDATE shirts SET shirt_size = 'XS', color = 'off white'
WHERE (color = 'white' AND shirt_id <> 0);
SHOW warnings;

-- DELETES
DELETE FROM shirts WHERE (last_worn = 200 AND shirt_id <> 0);
DELETE FROM shirts WHERE (article = 'tank top' AND shirt_id <> 0);
DELETE FROM shirts WHERE shirt_id <> 0;

-- DROPS
DROP TABLE shirts;