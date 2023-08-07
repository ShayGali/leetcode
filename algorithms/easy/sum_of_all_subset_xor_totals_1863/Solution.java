package algorithms.easy.sum_of_all_subset_xor_totals_1863;

public class Solution {
    public static void main(String[] args) {
        new Solution().subsetXORSum(new int[]{1, 3});
    }

    public int subsetXORSum(int[] nums) {
        return subsetXORSum(nums, 0, 0);
    }

    public int subsetXORSum(int[] nums, int start, int current) {
        if (start == nums.length) {
            return current;
        }
        int with = subsetXORSum(nums, start + 1, current ^ nums[start]);
        int without = subsetXORSum(nums, start + 1, current);
        return with + without;
    }
}
