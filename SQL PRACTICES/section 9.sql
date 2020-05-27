-- AGGREGATE FUNCTIONS (count, sum, min, max, etc) IN DATABASES (working with aggregate data).
SELECT * FROM books;

-- COUNT (Counting data in a database)
-- If using distinct, and count, it must come after count
SELECT COUNT(*) AS total FROM books;
SELECT COUNT(DISTINCT author_fname) AS "Author first Names" FROM books;
SELECT COUNT(DISTINCT author_fname) AS "Author last Names" FROM books;
SELECT COUNT(DISTINCT author_fname, author_lname) AS "Author Names" FROM books;
SELECT COUNT(*) FROM books WHERE title LIKE "%the%";

-- GROUP BY (This summarizes or aggregates identical data into single rows)
SELECT author_fname, author_lname, COUNT(*) AS 'No of Books' FROM books GROUP BY author_lname, author_fname;
SELECT CONCAT('In ', released_year, ' ', COUNT(*), ' books released.') AS "Comment" FROM books GROUP BY released_year;
-- MIN and MAX (To get the minimum or maximum value in a table, can be used in combo with group by)
SELECT MIN(released_year) FROM books;
SELECT MIN(pages) FROM books;
SELECT MAX(released_year) FROM books;
SELECT MAX(pages) FROM books;
-- NB: Sub queries demands a high execution time, making output of the query slow in a very large dataset
SELECT title, pages FROM books WHERE pages = (SELECT MAX(pages) FROM books);
-- If sub queries can be avoided, the do so, as in the above, the below can work.
SELECT title, pages FROM books ORDER BY pages DESC LIMIT 1;

-- MIN/MAX + GROUP BY
SELECT author_fname, author_lname, MIN(released_year) AS 'First Release Year' FROM books GROUP BY author_lname, author_fname;
SELECT author_fname, author_lname, MAX(pages) FROM books GROUP BY author_lname, author_fname;
SELECT CONCAT(author_fname, " ", author_lname) AS author, MAX(pages) AS "Longest Book"
FROM books GROUP BY author_lname, author_fname;

-- SUM (Add Numeric values together), can be used with group by
SELECT SUM(pages) FROM books;
SELECT SUM(released_year) FROM books;
SELECT CONCAT(author_fname, " ", author_lname) AS "Author Name", SUM(pages) AS "Total Pages"
FROM books GROUP BY author_lname, author_fname;
SELECT CONCAT(author_fname, " ", author_lname) AS "Author Name", SUM(released_year) AS "Total Pages"
FROM books GROUP BY author_lname, author_fname;

-- AVERAGE (similar to mean) syntax AVG
SELECT AVG(released_year) FROM books;
SELECT AVG(pages) FROM books;
SELECT AVG(stock_quantity) FROM books GROUP BY released_year;
SELECT CONCAT(author_fname, " ", author_lname) AS "Author Name",
	AVG(stock_quantity) AS "Avg. Stock",
    SUM(stock_quantity) AS "Tot. Stock"
FROM books GROUP BY released_year;


-- EXCERCISES
SELECT COUNT(*) FROM books;
SELECT released_year, COUNT(*) AS "No of Books" FROM books GROUP BY released_year;
SELECT SUM(stock_quantity) FROM books;
SELECT CONCAT(author_fname, "  ", author_lname) AS "Author Name", AVG(released_year)
FROM books GROUP BY author_lname, author_fname;
SELECT CONCAT(author_fname, "  ", author_lname) AS "Author Name", pages
FROM books WHERE pages = (SELECT MAX(pages) FROM books);
-- OR
SELECT CONCAT(author_fname, "  ", author_lname) AS "Author Name", pages
FROM books ORDER BY pages DESC LIMIT 1;
SELECT released_year AS year, COUNT(*) AS "# books", AVG(pages) AS "avg pages"
FROM books GROUP BY released_year;