CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT BEGIN declare offst int default 0;

set
    offst = N - 1;

RETURN (
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
                    1 OFFSET offst
            ),
            NULL
        ) AS SecondHighestSalary
);

END