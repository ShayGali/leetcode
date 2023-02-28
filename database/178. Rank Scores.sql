SELECT Scores.score, COUNT(distinct_scorse.Scores)


(SELECT DISTINCT score FROM Scores ORDER BY score DESC ) AS distinct_scorse