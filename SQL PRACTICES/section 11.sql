-- LOGICAL OPERATORS (OR, AND, NOT, etc) used to add logic to SQL statements
use book_shop;

-- != (NOT EQUALS) this is opposite of = (EQUAL TO).
SELECT title, released_year FROM books WHERE released_year = 2017;
SELECT title, released_year FROM books WHERE released_year != 2017;
SELECT title, author_lname FROM books WHERE author_lname = 'Harris';
SELECT title, author_lname FROM books WHERE author_lname != 'Harris';

-- NOT LIKE opposite of LIKE, used for pattern matching
SELECT title FROM books WHERE title LIKE 'W%';
SELECT title FROM books WHERE title NOT LIKE 'W%';

-- > (GREATER THAN), < (LESS THAN), >= (GREATER THAN OR EQUAL TO), <= (LESS OR EQUAL)
-- They work only on numeric data types
SELECT title, released_year FROM books ORDER BY released_year;
SELECT title, released_year FROM books WHERE released_year > 2000 ORDER BY released_year;
SELECT title, released_year FROM books WHERE released_year >= 2000 ORDER BY released_year;
SELECT title, stock_quantity FROM books WHERE stock_quantity >= 100;
SELECT 99 = 1; -- Returns a boolean TRUE (1) or FALSE (0)
SELECT 100 > 5;
SELECT -15 > 15;
SELECT 9 > -10;
SELECT 1 > 1;
SELECT 'a' > 'b';
SELECT 'A' >= 'a';

SELECT title, released_year FROM books WHERE released_year < 2000 ORDER BY released_year;
SELECT title, released_year FROM books WHERE released_year <= 2000 ORDER BY released_year;
-- In comparing alphabets, same alphabets (UPPER) or (SMALLER) case are equal, not less or greater than.

-- && or AND (used interchangeably) is used to chain many logics which must all evaluate to TRUE
SELECT title, author_lname, released_year FROM books WHERE author_lname='Eggers' AND released_year > 2010;
-- OR
SELECT title, author_lname, released_year FROM books WHERE author_lname='Eggers' && released_year > 2010;
SELECT title, author_lname, released_year FROM books WHERE author_lname='Eggers'
&& released_year > 2010 AND title LIKE '%novel%';

-- || or OR (used interchangeably) is used to chain many logics which evaluates to TRUE when any of the logics is TRUE
SELECT title, author_lname, released_year FROM books WHERE author_lname='Eggers' || released_year > 2010;
SELECT title, author_lname, released_year, stock_quantity FROM books WHERE author_lname='Eggers'
|| released_year > 2010 || stock_quantity > 100;
-- NB: OR and AND can be combined in a single query, depending on what needs to be achieved

-- BETWEEN (Allows for selection of data which fits into a specified range)
-- WHEN USING BETWEEN, WE MUST USE THE ACCOMPAINIG 'AND' not &&
SELECT title, released_year FROM books WHERE released_year >= 2004 AND released_year <= 2015;
-- NB: BETWEEN always does inclusiness
SELECT title, released_year FROM books WHERE released_year BETWEEN 2004 AND 2015;
-- NB: NOT BETWEEN is opposite of BETWEEN.
SELECT title, released_year FROM books WHERE released_year NOT BETWEEN 2004 AND 2015 ORDER BY released_year;
-- CAST(data AS datatype): A function we used to convert data from one type to another
-- e.g CAST('2020-11-12' AS DATETIME)
SELECT CAST('2020-11-12' AS DATETIME);
-- NB: When using BETWEEN to compare dates, its best to cast them first
use new_test_db;
SELECT * FROM people;
SELECT name, birth_dt FROM people WHERE birth_dt
BETWEEN CAST('1980-01-01' AS DATETIME) AND CAST('2020-01-01' AS DATETIME);

-- IN: Used to check if a given value exists in a specified set
SELECT title, author_lname FROM books WHERE
	author_lname='Carver' OR
	author_lname='Lahiri' OR
	author_lname='Smith';
-- Using IN we can do:
SELECT title, author_lname FROM books WHERE
	author_lname IN ('Carver', 'Lahiri', 'Smith');
SELECT title, author_lname FROM books WHERE
	author_lname IN ('Carver', 'Lahiri', 'Smith', 'Eggers');
SELECT title, released_year FROM books WHERE
released_year IN (2004, 2017, 1985);
-- NOT IN: Opposite of IN
SELECT title, author_lname FROM books WHERE
	author_lname NOT IN ('Carver', 'Lahiri', 'Smith', 'Eggers');
SELECT title, released_year FROM books WHERE
	released_year NOT IN (2000, 2002, 2004, 2006, 2008, 2010, 2012, 2014, 2016);
SELECT title, released_year FROM books WHERE
	released_year >= 2000 AND
	released_year NOT IN (2000, 2002, 2004, 2006, 2008, 2010, 2012, 2014, 2016)
    ORDER BY released_year;

-- % (MODULO operator or remainder operator), mostly used to test if a number is even
SELECT title, released_year FROM books WHERE
	released_year >= 2000 AND released_year % 2 != 0 ORDER BY released_year;

-- CASE STATEMENTS
SELECT title, released_year,
	CASE
		WHEN released_year >= 2000 THEN 'Modern Lit'
        ELSE '20th Century Lit'
	END AS Genre
FROM books ORDER BY Genre;

SELECT title, stock_quantity,
	CASE
		WHEN stock_quantity BETWEEN 0 AND 50 THEN '*'
        WHEN stock_quantity BETWEEN 51 AND 100 THEN '**'
        ELSE '***'
	END AS star
FROM books ORDER BY star DESC;
SELECT title,
	CASE
		WHEN stock_quantity BETWEEN 0 AND 50 THEN '*'
        WHEN stock_quantity BETWEEN 51 AND 100 THEN '**'
        ELSE '***'
	END AS star
FROM books ORDER BY star DESC;
SELECT title, stock_quantity,
	CASE
		WHEN stock_quantity <= 50 THEN '*'
        WHEN stock_quantity <= 100 THEN '**'
        ELSE '***'
	END AS star
FROM books ORDER BY star DESC;

-- EXERCISE
SELECT 10 != 10;
SELECT 15 > 4 && 99 - 5 <= 94;
SELECT 1 IN (5, 3) || 9 BETWEEN 8 AND 10;
SELECT title, released_year FROM books WHERE released_year < 1980;
SELECT title, author_lname FROM books WHERE author_lname IN ('Eggers', 'Chabon');
-- OR
SELECT title, author_lname FROM books WHERE author_lname='Eggers'
	|| author_lname='Chabon';
SELECT title, author_lname, released_year FROM books
WHERE author_lname='Lahiri' AND released_year > 2000;
SELECT title, pages FROM books WHERE pages BETWEEN 100 AND 200;
SELECT title, author_lname FROM books WHERE author_lname LIKE 'c%'
|| author_lname LIKE 's%';
-- OR
SELECT title, author_lname FROM books
WHERE SUBSTR(author_lname, 1, 1) = 'C' OR SUBSTR(author_lname, 1, 1) = 'S';
-- OR
SELECT title, author_lname FROM books WHERE SUBSTR(author_lname, 1, 1) IN ('C', 'S');
SELECT title, author_lname,
	CASE
		WHEN title LIKE '%stories' THEN 'Short stories'
        WHEN title LIKE '%Just Kids%' 
			|| title LIKE 'A heartbreaking work%' THEN 'Memoir'
        ELSE 'Novel'
	END AS TYPE
FROM books ORDER BY TYPE;
SELECT title, author_lname,
	CONCAT(
		COUNT(*),
        CASE
			WHEN COUNT(*) <= 1 THEN ' book'
			ELSE ' books'
		END
	) AS COUNT 
FROM books GROUP BY author_lname, author_fname  ORDER BY COUNT DESC;