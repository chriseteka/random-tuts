-- RELATIONSHIPS AND JOINS
-- ONE TO ONE, ONE TO MANY, MANY TO MANY
-- WE START WITH 1:MANY (ONE-TO-MANY)
CREATE DATABASE transactions;
USE transactions;
CREATE TABLE Customers(
	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL DEFAULT "First_Name Nil",
    last_name VARCHAR(100) NOT NULL DEFAULT "Last_Name Nil",
    email VARCHAR(200) UNIQUE NOT NULL
);

CREATE TABLE orders(
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE,
    amount DECIMAL(8,2),
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(id)
);
DESC Customers;
DESC orders;
DROP TABLE Customers;

SELECT * FROM customers;
SELECT * FROM orders;
INSERT INTO customers (first_name, last_name, email) 
VALUES ('Boy', 'George', 'george@gmail.com'),
       ('George', 'Michael', 'gm@gmail.com'),
       ('David', 'Bowie', 'david@gmail.com'),
       ('Blue', 'Steele', 'blue@gmail.com'),
       ('Bette', 'Davis', 'bette@aol.com');
       
INSERT INTO orders (order_date, amount, customer_id)
VALUES ('2016/02/10', 99.99, 1),
       ('2017/11/11', 35.50, 1),
       ('2014/12/12', 800.67, 2),
       ('2015/01/03', 12.50, 2),
       ('1999/04/11', 450.25, 5);
       
-- NOT ADVICEABLE DUE TO TIME COMPLEXITY OF RUNNING SUB QUERIES
SELECT * FROM orders WHERE customer_id = (SELECT id FROM customers WHERE email='george@gmail.com');

-- CROSS JOIN OR CARTESIAN JOIN OR IMPLICIT JOIN (Pretty useless), Dont try next time
SELECT * FROM customers, orders;

-- IMPLICIT INNER JOIN
SELECT * FROM customers, orders WHERE customers.id = customer_id;
SELECT first_name, last_name, order_date, amount
FROM customers, orders 
WHERE customers.id = customer_id;

-- EXPLICIT INNER JOIN (this uses the key word, 'JOIN table_name ON')
SELECT * FROM customers
JOIN orders
	ON customers.id = orders.customer_id;
    
SELECT first_name, last_name, order_date, amount FROM customers
JOIN orders
	ON customers.id = orders.customer_id;
    
SELECT first_name, last_name, order_date, amount FROM orders
JOIN customers
	ON orders.customer_id = customers.id;
-- SYNTAX is SELECT from a table JOIN another table ON specified condition(s) == EXPLICIT INNER JOIN
-- NB: We can sort or order the results from a join statement to get even more fancier
-- Below we try to group the orders by the customer id and arrange them by the amounts of their orders
SELECT 
	customer_id,
    CONCAT(
		first_name,
        " ",
		last_name
	) AS "Full Name", 
    SUM(amount) AS "Total Spent"
FROM customers
JOIN orders
	ON customers.id = orders.customer_id
GROUP BY orders.customer_id
ORDER BY 3 DESC;
-- NB: We can write 'INNER JOIN' or simply 'JOIN'
SELECT * FROM customers
INNER JOIN orders
	ON customers.id = orders.customer_id;

-- LEFT JOINS (Joins two tables with a unism between the first table in the select statement and the other(s) after it.
-- In the below statement, all customer were cumpolsarily mapped to an order, for those that dont have orders, they get Null Values
-- It is usually used to show all element in the left (first table of the statement) and their corresponding activities on the right
-- table, not minding if they have any relevant data in the right table, everyone is accounted for and reported for in the left table
SELECT * FROM customers
LEFT JOIN orders
	ON customers.id = orders.customer_id;
    
SELECT
	first_name,
    last_name,
    order_date,
    amount
FROM customers
LEFT JOIN orders
	ON customers.id = orders.customer_id;

-- Notice we introduced the IFNULL function which takes 2 args (1 is the param 2test, 2 is d replacement if param 2test is null)
SELECT
	first_name,
    last_name,
    IFNULL(SUM(amount), 0) AS total_spent
FROM customers
LEFT JOIN orders
	ON customers.id = orders.customer_id
GROUP BY customers.id
ORDER BY total_spent;

-- RIGHT JOIN similar to LEFT JOIN more like opposite (does it from the second table)
SELECT * FROM customers
RIGHT JOIN orders
	ON customers.id = orders.customer_id;
    
DELETE FROM orders WHERE customer_id = 1;


-- ON DELETE CASCADE (Deleting parents alongside their children having a foreig key)
-- This command is added when creating a table that has the foreign key in it
DROP TABLE orders, customers;
CREATE TABLE Customers(
	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL DEFAULT "First_Name Nil",
    last_name VARCHAR(100) NOT NULL DEFAULT "Last_Name Nil",
    email VARCHAR(200) UNIQUE NOT NULL
);

CREATE TABLE orders(
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE,
    amount DECIMAL(8,2),
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

SELECT * FROM customers;
SELECT * FROM orders;
DELETE FROM customers WHERE email = "george@gmail.com";

-- NB: The statements below are same haven known what RIGHT and LEFT JOINS are
SELECT
	first_name,
    last_name,
    IFNULL(SUM(amount), 0) AS total_spent
FROM customers
LEFT JOIN orders
	ON orders.customer_id = customers.id
GROUP BY customers.id;
-- ABOVE 'LEFT JOIN' SAME AS BELOW 'RIGHT JOIN'
SELECT
	first_name,
    last_name,
    IFNULL(SUM(amount), 0) AS total_spent
FROM orders
RIGHT JOIN customers
	ON orders.customer_id = customers.id
GROUP BY customers.id;

-- EXERCISE
CREATE TABLE students(
	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) UNIQUE
);

CREATE TABLE papers(
	title VARCHAR(100),
    grade INT,
    student_id INT,
    FOREIGN KEY(student_id) REFERENCES students(id) ON DELETE CASCADE
);

INSERT INTO students (first_name) 
VALUES 
	('Caleb'), 
	('Samantha'), 
	('Raj'), 
	('Carlos'), 
	('Lisa');

INSERT INTO papers (student_id, title, grade ) 
VALUES
	(1, 'My First Book Report', 60),
	(1, 'My Second Book Report', 75),
	(2, 'Russian Lit Through The Ages', 94),
	(2, 'De Montaigne and The Art of The Essay', 98),
	(4, 'Borges and Magical Realism', 89);
    
SELECT * FROM students;
SELECT * FROM papers;

SELECT
	first_name,
    title,
    grade
FROM students
	INNER JOIN papers ON students.id = papers.student_id
ORDER BY grade DESC;
-- OR
SELECT
	first_name,
    title,
    grade
FROM students
	RIGHT JOIN papers ON students.id = papers.student_id
ORDER BY grade DESC;

SELECT
	first_name,
    title,
    grade
FROM students LEFT JOIN papers ON students.id = papers.student_id;

SELECT
	first_name,
    IFNULL(title, "MISSING"),
    IFNULL(grade, 0)
FROM students LEFT JOIN papers ON students.id = papers.student_id;

SELECT
	first_name,
    IFNULL(AVG(grade), 0) AS average
FROM students LEFT JOIN papers ON students.id = papers.student_id
GROUP BY students.id
ORDER BY average DESC;
-- OR
SELECT
	first_name,
    IFNULL(AVG(grade), 0) AS average
FROM students LEFT JOIN papers ON students.id = papers.student_id
GROUP BY first_name
ORDER BY average DESC;

SELECT
	first_name,
    IFNULL(AVG(grade), 0) AS average,
    CASE
		WHEN AVG(grade) IS NULL THEN "FAILING"
		WHEN AVG(grade) >= 75 THEN "PASSING"
        ELSE "FAILING"
	END AS passing_status
FROM students LEFT JOIN papers ON students.id = papers.student_id
GROUP BY students.id
ORDER BY average DESC;
-- OR
SELECT
	first_name,
    IFNULL(AVG(grade), 0) AS average,
    CASE
		WHEN AVG(grade) IS NULL THEN "FAILING"
		WHEN AVG(grade) >= 75 THEN "PASSING"
        ELSE "FAILING"
	END AS passing_status
FROM students LEFT JOIN papers ON students.id = papers.student_id
GROUP BY first_name
ORDER BY average DESC;