package algorithms.easy.maximum_product_of_two_elements_in_an_array_1464;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    // using two variables
    public int maxProduct(int[] nums) {
        int max1, max2;
        if (nums[0] > nums[1]) {
            max1 = nums[0];
            max2 = nums[1];
        } else {
            max1 = nums[1];
            max2 = nums[0];
        }

        for (int k = 2; k < nums.length; k++) {
            if (nums[k] > max1) {
                max2 = max1;
                max1 = nums[k];
            } else if (nums[k] > max2) {
                max2 = nums[k];
            }
        }

        return (max1 - 1) * (max2 - 1);
    }

    public int maxProductHeap(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums) heap.add(n);
        return (heap.poll() - 1) * (heap.poll() - 1);
    }

    public int maxProductTwoPointer(int[] nums) {
        int i = 0, j = 1;
        if (nums[i] < nums[j]) {
            i = 1;
            j = 0;
        }

        for (int k = 2; k < nums.length; k++) {
            if (nums[k] > nums[i]) {
                j = i;
                i = k;
            } else if (nums[k] > nums[j]) {
                j = k;
            }
        }

        return (nums[i] - 1) * (nums[j] - 1);
    }
}
