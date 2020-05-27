-- STRING FUNCTIONS (To run an sql file from cmd "source file-name.sql", bingo).
CREATE DATABASE book_shop;
use book_shop;
CREATE TABLE books 
	(
		book_id INT NOT NULL AUTO_INCREMENT,
		title VARCHAR(100),
		author_fname VARCHAR(100),
		author_lname VARCHAR(100),
		released_year INT,
		stock_quantity INT,
		pages INT,
		PRIMARY KEY(book_id)
	);

INSERT INTO books (title, author_fname, author_lname, released_year, stock_quantity, pages)
VALUES
('The Namesake', 'Jhumpa', 'Lahiri', 2003, 32, 291),
('Norse Mythology', 'Neil', 'Gaiman',2016, 43, 304),
('American Gods', 'Neil', 'Gaiman', 2001, 12, 465),
('Interpreter of Maladies', 'Jhumpa', 'Lahiri', 1996, 97, 198),
('A Hologram for the King: A Novel', 'Dave', 'Eggers', 2012, 154, 352),
('The Circle', 'Dave', 'Eggers', 2013, 26, 504),
('The Amazing Adventures of Kavalier & Clay', 'Michael', 'Chabon', 2000, 68, 634),
('Just Kids', 'Patti', 'Smith', 2010, 55, 304),
('A Heartbreaking Work of Staggering Genius', 'Dave', 'Eggers', 2001, 104, 437),
('Coraline', 'Neil', 'Gaiman', 2003, 100, 208),
('What We Talk About When We Talk About Love: Stories', 'Raymond', 'Carver', 1981, 23, 176),
("Where I'm Calling From: Selected Stories", 'Raymond', 'Carver', 1989, 12, 526),
('White Noise', 'Don', 'DeLillo', 1985, 49, 320),
('Cannery Row', 'John', 'Steinbeck', 1945, 95, 181),
('Oblivion: Stories', 'David', 'Foster Wallace', 2004, 172, 329),
('Consider the Lobster', 'David', 'Foster Wallace', 2005, 92, 343);

SELECT * FROM books;

-- CONCATINATION (CONCAT), CONCATINATION WITH SPACE (CONCAT_WS).
SELECT CONCAT(author_fname, ' ', author_lname) AS 'Full Name' FROM books;
SELECT author_fname AS first, author_lname AS last,
	CONCAT(author_fname, ' ', author_lname) AS full
	FROM books;
SELECT CONCAT_WS(' - ', title, author_fname, author_lname) AS descr
	FROM books;
    
-- SUBSTRING LIKE THAT IN JAVA SUBSTRING(word, startFrom, endAt) or SUBSTRING(word, startFrom).
SELECT SUBSTRING('King Jali of Java', 5, 6) AS test;
-- We can do SUBSTRING(word, neg int), this outputs the strings counting from the back
SELECT SUBSTRING('Adebayo', -3) AS Reverse; -- We can select last four digits of an ATM card number
SELECT SUBSTRING(title, 1, 10) AS "short form" FROM books;
-- We can also use a short for as SUBSTR(word, start, end)
SELECT SUBSTR(title, 1, 10) AS "short title" FROM books;
SELECT CONCAT(
		SUBSTR(title, 1, 10),
		"..."
    ) AS "short title"
FROM books;

-- REPLACEMENT REPLACE(word, removeStr, addStr), this also works like replace all alpha with another
SELECT REPLACE ("Henry", "Hen", "Dia") AS "After replace";
SELECT REPLACE ("Mohammed", "m", "l") AS replaced; -- REPLACE IS CASE SENSITIVE.
SELECT REPLACE (title, "e", "3") AS "Formatted Title" FROM books;
SELECT CONCAT(
		SUBSTRING(
			REPLACE (title, 'e', '3'),
			1, 10
        ),
		"..."
    )AS "Formatted Title" 
FROM books;

-- REVERSING REVERSE(word)
SELECT REVERSE('Olay Boy') AS "trial reverse";
SELECT REVERSE(
		CONCAT(
			SUBSTRING(
				REPLACE (title, 'e', '3'),
				1, 10
			),
			"..."
		)
    )AS "Formatted Title" 
FROM books;
SELECT CONCAT_WS(
	" ", 
    author_fname,
    REVERSE(
		author_fname
        )
    ) AS "palindrone"
FROM books;

-- CHAR_LENGTH, Tells how many characters are in a string counts both spaces, CHAR_LENGTH(word)
SELECT CHAR_LENGTH("mumu man") AS "word length";
SELECT 
	author_lname,
    CHAR_LENGTH(author_lname) AS "Name length" 
FROM books;
SELECT CONCAT(
		author_lname,
		" is ",
		CHAR_LENGTH(
			author_lname
		),
		" characters long"
    ) AS "sentence"
FROM books;

--	UPPER AND LOWER, for switching words to either all CAPS or all LOWs, UPPER(word) and LOWER(word)
SELECT UPPER('Hello World') AS caps;
SELECT LOWER('Hello World') AS lows;
SELECT UPPER(title) AS "Book Title" FROM books;
SELECT CONCAT(
	"MY FAVOURITE BOOK IS ",
    UPPER(title)
    ) AS sentence
FROM books;

-- Exercises
SELECT REVERSE(UPPER('Why does my cat look at me with such hatred')) AS sentence;
SELECT REPLACE(CONCAT('I', ' ', 'like', ' ', 'cats'), ' ', '-') AS sentence;
SELECT REPLACE(title, ' ', '->') AS 'title' FROM books;
SELECT author_lname AS forwards, REVERSE(author_lname) AS backwards FROM books;
SELECT UPPER(concat(author_fname, ' ', author_lname)) AS 'full name in caps'
FROM books;
SELECT CONCAT(title, ' was released in ', released_year) AS blurb FROM books;
SELECT title, CHAR_LENGTH(title) AS 'title length' FROM books;
SELECT CONCAT(SUBSTRING(title, 1, 10), '...') AS 'short title',
    CONCAT(author_lname, ',', author_fname) AS author,
    CONCAT(stock_quantity, ' in stock') AS quantity
FROM books;