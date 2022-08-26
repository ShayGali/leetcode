-- https://leetcode.com/problems/second-highest-salary/
-- SELECT
--     max(salary) AS SecondHighestSalary
-- FROM
--     Employee
-- WHERE
--     salary < (
--         SELECT
--             max(salary)
--         FROM
--             Employee
--     )
SELECT
    IFNULL (
        (
            SELECT
                DISTINCT salary
            FROM
                Employee
            ORDER BY
                salary DESC
            LIMIT
                1 offset 1
        ),
        NULL
    ) AS SecondHighestSalary