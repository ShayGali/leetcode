
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        return self.combinationSumHelper(candidates,target,0)

    def combinationSumHelper(self, candidates: List[int], target: int, start: int) -> List[List[int]]:
        if target <= 0:
            return []
        
        res = []
        for i in range(start, len(candidates)):
            candidate = candidates[i]
            if candidate == target:
                res.append([candidate])
            elif candidate < target:
                combos = self.combinationSumHelper(candidates, target - candidate, i)
                for comb in combos:
                    res.append(comb + [candidate])
            else:
                break

        
        return res
