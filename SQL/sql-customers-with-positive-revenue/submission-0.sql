-- Write your query below
SELECT DISTINCT customer_id
FROM Customers
WHERE revenue > 0
AND year = 2020;