package algorithms.easy.largest_perimeter_triangle_976;

import java.util.Arrays;
/*
משולש הוא תקין אם סכום כל שתי צלעות קטן מהשלישי.
אפשר למיין את המערך
ולהתחיל מהסוף,
אם נמצא איבר שהוא גדול מהשני קודמים שלו אז זה אומר שזה משולש תקין
 */
public class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }
}
