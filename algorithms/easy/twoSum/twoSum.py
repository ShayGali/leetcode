from typing import List


class Solution:
    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    #     for i, val in enumerate(nums):
    #         for j, val2 in enumerate(nums[i + 1:]):
    #             if val + val2 == target:
    #                 return [i, j + i + 1]

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = dict()
        for i, val in enumerate(nums):
            if val in d:
                return [d[val], i]
            d[target - val] = i


if __name__ == '__main__':
    solution = Solution()
    nums = [2, 7, 11, 15]
    target = 9
    print(solution.twoSum(nums, target))
