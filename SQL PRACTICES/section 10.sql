-- DATA TYPES (A bit advanced ones)
-- Texts (VARCHAR (has varied length), CHAR (has a fixed length of n bit from 0 to 255 depending on your declaration)).
CREATE DATABASE new_test_db;
use new_test_db;
SELECT database();
CREATE TABLE dogs(
	name CHAR(5),
    breed VARCHAR(10)
);
DESC dogs;
SELECT * FROM dogs;
INSERT INTO dogs(name, breed) VALUES ("Bob", "Beagle");
INSERT INTO dogs(name, breed) VALUES ("Robby", "Corgi");
INSERT INTO dogs(name, breed) VALUES ("Princess Jane", "Retriever");
SHOW WARNINGS;

-- Numbers (INT = whole numbers, DECIMAL = nums with deccimal points)
-- DECIMAL is declared thus DECIMAL(digits, nos after) e.g DECIMAL(10,2) can hold 11.77
CREATE TABLE item (price DECIMAL(5,2));
DESC item;
SELECT * FROM item;
INSERT INTO item(price) VALUES (7);
INSERT INTO item(price) VALUES (77239903734);
INSERT INTO item(price) VALUES (34.88);
INSERT INTO item(price) VALUES (298.9999);
INSERT INTO item(price) VALUES (1.9999);

-- FLOAT and DOUBLE, also like DECIMAL, used to represent non whole numbers
-- They can store larger number with less space and are not entirely accurate as decimal
-- When precision is a neccessity, use DECIMAL, otherwise use DOUBLE (2x FLOAT)
CREATE TABLE thingies(price FLOAT);
SELECT * FROM thingies;
INSERT INTO thingies(price) VALUES (88.45);
INSERT INTO thingies(price) VALUES (8877.45);
INSERT INTO thingies(price) VALUES (88776655.44);

-- DATE, TIME and DATETIME
-- DATE (Stores date value with no time and of the format "YYYY-MM-DD")
-- TIME (Stores time value with no date and of the format "HH:mm:ss")
-- DATETIME (Stores time value with date value along side and of the format "YYYY-MM-DD HH:mm:ss")
-- NB: DATETIME IS THE MOST VERSERTILE AND THE MOST USEFUL

CREATE TABLE people(
	name VARCHAR(255),
    birth_date DATE,
    birth_time TIME,
    birth_dt DATETIME
);

INSERT INTO people(name, birth_date, birth_time, birth_dt)
VALUES('Padma', '1983-11-11', '10:02:04', '1983-11-11 10:02:04');
INSERT INTO people(name, birth_date, birth_time, birth_dt)
VALUES('Larry', '1943-12-25', '04:10:42', '1943-12-25 04:10:42');

SELECT * FROM people;

-- We considet the following functions, which are also used in date maths
-- CURDATE() used to get current date, CURTIME() used to get current time
-- and NOW() used to get current datetime
INSERT INTO people(name, birth_date, birth_time, birth_dt)
VALUES('Toaster', CURDATE(), CURTIME(), NOW());
SELECT CURDATE();

-- Date Formatting
SELECT name, birth_date FROM people;
SELECT name, birth_date, DAY(birth_date) FROM people; -- DAY() Extracts the day from the date
SELECT name, birth_date, DAYNAME(birth_date) FROM people; -- DAYNAME() Extracts the day name from the date
SELECT name, birth_date, DAYOFWEEK(birth_date) FROM people; -- DAYOFWEEK() Extracts the day of week from the date
SELECT name, birth_date, DAYOFYEAR(birth_date) FROM people; -- DAYOFYEAR() Extracts the day of year from the date

-- The enlisted function above only works on DATE and DATETIME and not on TIME
-- it will not throw error, it will only return null
-- Others include MONTH(), MONTHNAME(), etc
-- For time we can do things like HOUR(), MINUTE(), SECOND()
SELECT name, birth_dt, DAY(birth_dt) FROM people;
SELECT name, birth_dt, DAYNAME(birth_dt) FROM people;
SELECT name, birth_dt, DAYOFWEEK(birth_dt) FROM people;
SELECT name, birth_dt, DAYOFYEAR(birth_dt) FROM people;
-- NB: To nicely format date and datetime, checkout the documentation, and the regex needed
-- This is most time achieved using the DATE_FORMAT() and TIME_FORMAT()
SELECT DATE_FORMAT(birth_dt, '%W') FROM people;
SELECT DATE_FORMAT(birth_dt, '%m/%d/%Y') FROM people;

-- DATE MATH, we now look at :
-- DATEDIFF() = difference in days btwn 2dates or datetimes
-- DATE_ADD used to add two dates or datetimes, works along side with the INTERVAL keyword, this does not support chaining 
-- using the +(plus sign) and -(minus sign) also works for manipulating dates, used alongside INTERVAL, supports chaining
SELECT DATEDIFF(NOW(), birth_date) FROM people;
SELECT name, birth_date, DATEDIFF(NOW(), birth_date) FROM people;
SELECT birth_dt FROM people;
SELECT name, birth_dt, DATE_ADD(birth_dt, INTERVAL 1 MONTH) FROM people;
SELECT name, birth_dt, DATE_ADD(birth_dt, INTERVAL 10 SECOND) FROM people;
SELECT name, birth_dt, DATE_ADD(birth_dt, INTERVAL 3 QUARTER) FROM people;
SELECT name, birth_dt, (birth_dt + INTERVAL 1 MONTH) FROM people;
SELECT name, birth_dt, (birth_dt - INTERVAL 5 MONTH) FROM people;
SELECT name, birth_dt, (birth_dt + INTERVAL 15 MONTH + INTERVAL 10 HOUR) FROM people;

-- TIMESTAMPS (A datatype in mysql, in prog its used to track actual time when an event occurs)
-- It differs from DATETIME only in the range of supported time, of which DATETIME is bigger
-- Recommended only when storing dates in the present that needs not be modified, plus its smaller in size than DATETIME
CREATE TABLE comments(
	content VARCHAR(100),
    created_at TIMESTAMP DEFAULT NOW()
);
DESC comments;
SELECT * FROM comments2 ORDER BY changed_at DESC;
INSERT INTO comments2(content) VALUES ('LOL');
INSERT INTO comments2(content) VALUES ('i FIND THIS OFFENSIVE');
INSERT INTO comments2(content) VALUES ('Gibberish');

-- We can also use CURRENT_TIMESTAMP instead of NOW
-- We can use ON UPDATE keyword thus:
CREATE TABLE comments2(
	content VARCHAR(100),
    changed_at TIMESTAMP DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP
);

UPDATE comments2 SET content='This is not gibberish' WHERE (content='gibberish');
SHOW WARNINGS;

-- EXERCISE
CREATE TABLE inventory(
	item_name VARCHAR(150),
    price DECIMAL(8,2),
    quantity INT
);
DESC inventory;
INSERT INTO inventory(item_name, price, quantity)
VALUES('Biscuits', 1234567.980, 6), ('Maggie', 1234567892, 10);
SELECT * FROM inventory;
DROP TABLE inventory;
SELECT CURTIME();
SELECT CURDATE();
SELECT DAYOFWEEK(CURDATE());
SELECT DAYNAME(CURDATE());
SELECT DATE_FORMAT(NOW(), '%m/%d/%Y %h:%i:%s');
SELECT DATE_FORMAT(NOW(), '%M %D at %h:%i');
CREATE TABLE tweets(
	content VARCHAR(140),
    username VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);
-- OR
CREATE TABLE tweets(
	content VARCHAR(140),
    username VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
DESC tweets;