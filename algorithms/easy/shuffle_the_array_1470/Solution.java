package algorithms.easy.shuffle_the_array_1470;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0; i < 2 * n; i += 2) {
            res[i] = nums[i];
            res[i + 1] = nums[i + n];
        }
        return res;
    }
}
