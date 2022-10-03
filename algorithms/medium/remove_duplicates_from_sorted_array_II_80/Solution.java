package algorithms.medium.remove_duplicates_from_sorted_array_II_80;

public class Solution {
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 1) return 1;
        int last = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[last] < nums[i] || (last != i && nums[last - 1] < nums[i])) {
                last++;
                nums[last] = nums[i];
            }
        }
        return last + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length < 3) return nums.length;
        int last = 2;
        for (int i = 2; i < nums.length; i++)
            if (nums[i] != nums[last - 2])
                nums[last++] = nums[i];

        return last;
    }

    public static void main(String[] args) {
        new Solution().removeDuplicates2(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
    }
}

/*
[1,1,1,2,2,3]
[0,0,1,1,1,1,2,3,3]
[1,2,3,4]
[1,2,2,3,3,4,4]
[1,2,2,2,2,3,3,3,4,4,4,4]
[1]
[1,1]
[1,2,3]
[1,2,2]
[1,2]
*/