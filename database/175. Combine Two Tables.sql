-- https://leetcode.com/problems/combine-two-tables/
SELECT
    firstName,
    lastName,
    city,
    state
FROM
    Person
    Left JOIN Address ON Person.personID = Address.personID;