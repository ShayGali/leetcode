package algorithms.medium.kth_largest_element_in_an_array_215;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    static Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int l = 0, h = nums.length, i = nums.length - k;
        while (l < h) {
            int pivot = partition(nums, l, h);
            if (pivot < i) l = pivot + 1;
            else if (pivot > i) h = pivot - 1;
            else return nums[pivot];
        }
        return nums[l];
    }

    int partition(int[] nums, int l, int h) {
        int randomPivot = random.nextInt(h - l + 1) + l;
        int pivotVal = nums[randomPivot];
        swap(nums, h, randomPivot);
        int partitionIndex = l;
        for (int i = l; i < h; i++) {
            if (nums[i] < pivotVal) {
                swap(nums, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(nums, h, partitionIndex);
        return partitionIndex;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums)
            heap.add(n);
        while (k > 1) {
            heap.remove();
            k--;
        }
        return heap.remove();
    }

    @Test
    void test() {
        assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }


}
