package algorithms.medium.permutations_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }

    /*
    Runtime: 1 ms | Beats 98.58%
    Memory: 43.7 MB | Beats 90.84%
     */
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    public List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> allPermuteWithOutArr0;
        if (start == nums.length) {
            allPermuteWithOutArr0 = new ArrayList<>();
            allPermuteWithOutArr0.add(new ArrayList<>());
            return allPermuteWithOutArr0;
        }
        allPermuteWithOutArr0 = permute(nums, start + 1);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> l : allPermuteWithOutArr0) {
            List<Integer> clone = new ArrayList<>(l);
            for (int i = 0; i <= clone.size(); i++) {
                List<Integer> temp = new ArrayList<>(clone);
                temp.add(i, nums[start]);
                res.add(temp);
            }
        }
        return res;
    }

    /*
    Runtime: 2 ms | Beats 48.39%
    Memory: 43.9 MB | Beats 63.60%
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> allPermuteWithOutArr0;
        if (nums.length == 0) {
            allPermuteWithOutArr0 = new ArrayList<>();
            allPermuteWithOutArr0.add(new ArrayList<>());
            return allPermuteWithOutArr0;
        }

        allPermuteWithOutArr0 = permute1(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> l : allPermuteWithOutArr0) {
            List<Integer> clone = new ArrayList<>(l);
            for (int i = 0; i <= clone.size(); i++) {
                List<Integer> temp = new ArrayList<>(clone);
                temp.add(i, nums[0]);
                res.add(temp);
            }
        }
        return res;
    }
}