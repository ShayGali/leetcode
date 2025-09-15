package algorithms.medium.combination_sum_39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Solution().combinationSum2(arr, 6));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = combinationSum2(candidates, 0, target);
        return res != null ? res : new ArrayList<>();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int start, int target) {
        if (target < 0) return null;
        if (start == candidates.length || target == 0) {
            if (target != 0) return null;
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> with0 = combinationSum2(candidates, start + 1, target - candidates[start]);
        List<List<Integer>> without0 = combinationSum2(candidates, start + 1, target);
        if (with0 != null) {
            for (List<Integer> l : with0) l.add(candidates[start]);
            if (without0 != null)
                with0.addAll(without0);
            return with0;
        }
        return without0;
    }

}
