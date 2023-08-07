package algorithms.easy.number_of_good_pairs_1512;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int ans = 0;
        for (int val : map.values()) {
            if (val != 1)
                ans += val * (val - 1) / 2; // C(val,2) - get all the pair
        }
        return ans;
    }
}
