package algorithms.easy.contains_duplicate_217;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i =0; i<nums.length;i++){
            if(!s.add(nums[i]))return true;
        }
        return false;
    }
}
