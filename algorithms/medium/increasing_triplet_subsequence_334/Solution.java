package algorithms.medium.increasing_triplet_subsequence_334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE; // the i
        int j = Integer.MAX_VALUE; // the j
        for (int k : nums) {
            if (k <= i) { // smaller then i
                i = k;
            } else if (k <= j) { // bigger then i and smaller then j
                j = k;
            } else {
                return true; // i < j < k
            }
        }
        return false;
    }
}