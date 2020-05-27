INSERT INTO books
    (title, author_fname, author_lname, released_year, stock_quantity, pages)
    VALUES ('10% Happier', 'Dan', 'Harris', 2014, 29, 256), 
           ('fake_book', 'Freida', 'Harris', 2001, 287, 428),
           ('Lincoln In The Bardo', 'George', 'Saunders', 2017, 1000, 367);


SELECT title FROM books;

-- DISTINCTION (UNIQUE SELECT)
SELECT DISTINCT author_lname AS 'last name' FROM books;
SELECT DISTINCT released_year AS 'year released' FROM books;
SELECT DISTINCT CONCAT(author_fname, ' ', author_lname) FROM books; -- OR
SELECT DISTINCT author_fname AS 'first name', author_lname AS 'last name' FROM books;

-- SORTING USING ORDER BY (By default, it is in ascending order), we can set it to DESC or ASC
SELECT author_lname FROM books ORDER BY author_lname DESC;
SELECT title FROM books ORDER BY title DESC;
SELECT * FROM books;
SELECT title, released_year FROM books ORDER BY released_year DESC;
-- NB: You dont need to select a column to order by it
-- Using order by an int allows you to order by one of the columns being selected from the db
-- You can also order by two different columns and they will be applied one after the order
SELECT title, author_fname, author_lname FROM books ORDER BY 3 DESC;
SELECT title, author_fname, author_lname FROM books ORDER BY 3, 2; -- OR
SELECT title, author_fname, author_lname FROM books ORDER BY author_lname, author_fname;

-- LIMIT (Specifying the number of results we want returned)
SELECT title FROM books LIMIT 4;
SELECT title, released_year FROM books ORDER BY released_year DESC LIMIT 5;
-- NB: We can however specify a starting point and how many rows we want after it.
SELECT title, released_year FROM books ORDER BY released_year DESC LIMIT 0, 5;
SELECT title, released_year FROM books ORDER BY released_year DESC LIMIT 3, 5;
-- To access a particular row n, we do limit as 
SELECT title, released_year FROM books ORDER BY released_year DESC LIMIT 3, 5;

-- LIKE (Searching through the database against specified strings, known as pattern matchings)
-- % (wildcard, zero or more occurances of any character in the alphabeth), can be used anywhere
-- ____ (underscores, another wildcard which is used to select based on character length of data)
-- Regex can be created off these, check for more patterns that can be produced using them.
-- Back slashes (\) can be used to escape characters when pattern matching
SELECT * FROM books WHERE author_fname LIKE 'f%re%';
SELECT title FROM books WHERE title LIKE '%\%%';
SELECT title FROM books WHERE title LIKE '%\_%';
SELECT title FROM books WHERE title LIKE '%the%';
SELECT title, stock_quantity FROM books WHERE stock_quantity LIKE '____'; -- four underscores implies four characters long

-- Exercise
SELECT CONCAT(author_fname, ' ', author_lname) AS 'Full Name', title FROM books WHERE title LIKE '%stories%';
SELECT title, pages FROM books ORDER BY pages DESC LIMIT 1;
SELECT 
	CONCAT(title, ' - ', released_year) AS Summary 
FROM books ORDER BY released_year DESC LIMIT 3;
SELECT title, author_lname FROM books WHERE author_lname LIKE '% %';
SELECT title, released_year, stock_quantity FROM books ORDER BY stock_quantity ASC LIMIT 3;
SELECT title, author_lname FROM books ORDER BY author_lname, title;
SELECT title, author_lname FROM books ORDER BY 2, 1;
SELECT UPPER(
		CONCAT('my favourite author is ', author_fname, ' ', author_lname, '!')
) AS yell FROM books ORDER BY author_lname;
