package algorithms.easy.remove_element_27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int r = nums.length - 1;
        while (r >= 0 && nums[r] != val) r--;

        int count = 0;

        return count;
    }
}
