-- https://leetcode.com/problems/second-highest-salary/
SELECT
    max(salary) AS SecondHighestSalary
FROM
    Employee
WHERE
    salary < (
        SELECT
            max(salary)
        FROM
            Employee
    )