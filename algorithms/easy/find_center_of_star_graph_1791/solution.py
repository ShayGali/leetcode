class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        counter = {}
        for e in edges:
            u = counter.get(e[0],0)
            v = counter.get(e[1],0)
            if u == 1:
                return e[0]
            if v == 1:
                return e[1]
            
            counter[e[0]] = u + 1
            counter[e[1]] = v + 1
        
