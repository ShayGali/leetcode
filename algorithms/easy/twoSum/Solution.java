package algorithms.easy.twoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    // O(n^2)
    /*
    public int[] twoSum(int[] nums, int target) {
        int[] r = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    r[0] = i;
                    r[1] = j;
                    return r;
                }
            }
        }
        return null;
    }
    */

    //O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            map.put(target - nums[i], i);

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3,3}, 6)));
    }
}
