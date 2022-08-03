-- https://leetcode.com/problems/combine-two-tables/
SELECT
    firstName,
    lastName,
    city,
    state
FROM
    Person
    INNER JOIN Address ON Person.personID = Address.personID;