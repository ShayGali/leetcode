package algorithms.medium.sort_colors_75;

class Solution {
    //counting sort
    // Runtime 1ms, Memory Usage: 42.8 MB
    public void sortColors1(int[] nums) {
        int[] counter = new int[3];
        for (int n : nums) {
            counter[n]++;
        }
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (counter[j] == 0) j++;
            nums[i] = j;
            counter[j]--;
        }
    }

    public void sortColors2(int[] nums) {
        int l = 0, r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] == 0) {
                nums[i] = nums[l];
                nums[l] = 0;
                i++;
                l++;
            } else if (nums[i] == 2) {
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
            } else {
                i++;
            }
        }
    }
}