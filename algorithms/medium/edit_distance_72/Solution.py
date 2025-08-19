class Solution(object):
    def minDistance(self, word1, word2):
        n, m = len(word1), len(word2)
        dist = [[0]*(m+1) for _ in range(n+1)]

        for i in range(n+1):
            dist[i][0] = i
        for j in range(m+1):
            dist[0][j] = j

        for i in range(1, n+1):
            for j in range(1, m+1):
                if word1[i-1] == word2[j-1]:
                    dist[i][j] = dist[i-1][j-1]
                else:
                    dist[i][j] = 1 + min(
                        dist[i][j-1],    # insert
                        dist[i-1][j],    # delete
                        dist[i-1][j-1]   # replace
                    )
        return dist[n][m]


    def minDistanceNaive(self, word1, word2):
        if not word1:
            return len(word2)
        if not word2:
            return len(word1)

        if word1[-1] == word2[-1]:
            return self.minDistanceNaive(word1[:-1], word2[:-1])

        return 1 + min(
            self.minDistanceNaive(word1, word2[:-1]),  # insert
            self.minDistanceNaive(word1[:-1], word2),      # delete
            self.minDistanceNaive(word1[:-1], word2[:-1])  # replace
        )
