package algorithms.medium.search_in_rotated_sorted_array_33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int search(int[] nums, int target) {
        int rotationIndex = findRotationIndex(nums);
        return Math.max(bSearch(nums, target, 0, rotationIndex - 1), bSearch(nums, target, rotationIndex, nums.length - 1));
    }

    public int findRotationIndex(int[] nums) {
        int l = 0, h = nums.length - 1, mid;
        while (l < h) {
            mid = (l + h) / 2;
            if (nums[mid] > nums[h]) l = mid + 1;
            else h = mid;

        }
        return l;
    }

    public int bSearch(int[] nums, int target, int l, int h) {
        int mid;
        while (l <= h) {
            mid = (l + h) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) l = mid + 1;
            else h = mid - 1;
        }
        return -1;
    }

    @Test
    void testFindRotationIndex() {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {7, 0, 1, 2, 4, 5, 6};
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums4 = {3, 4, 5, 6, 7, 1, 2};

        assertEquals(4, findRotationIndex(nums1));
        assertEquals(1, findRotationIndex(nums2));
        assertEquals(0, findRotationIndex(nums3));
        assertEquals(5, findRotationIndex(nums4));
    }

    @Test
    public void testBinarySearch() {
        int[] nums1 = {1, 3, 5, 7, 9, 11, 13};
        int[] nums2 = {2, 4, 6, 8, 10};
        int[] nums3 = {1, 2, 3, 4, 5};

        assertEquals(4, bSearch(nums1, 9, 0, nums1.length - 1));
        assertEquals(2, bSearch(nums1, 5, 0, nums1.length - 1));
        assertEquals(0, bSearch(nums1, 1, 0, nums1.length - 1));
        assertEquals(-1, bSearch(nums1, 6, 0, nums1.length - 1));

        assertEquals(1, bSearch(nums2, 4, 0, nums2.length - 1));
        assertEquals(3, bSearch(nums2, 8, 0, nums2.length - 1));
        assertEquals(0, bSearch(nums2, 2, 0, nums2.length - 1));
        assertEquals(-1, bSearch(nums2, 5, 0, nums2.length - 1));

        assertEquals(2, bSearch(nums3, 3, 0, nums3.length - 1));
        assertEquals(4, bSearch(nums3, 5, 0, nums3.length - 1));
        assertEquals(0, bSearch(nums3, 1, 0, nums3.length - 1));
        assertEquals(-1, bSearch(nums3, 6, 0, nums3.length - 1));
    }

    @Test
    public void testSearchInRotatedArray() {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {7, 0, 1, 2, 4, 5, 6};
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {3, 4, 5, 6, 7, 1, 2};

        assertEquals(2, search(nums1, 6));
        assertEquals(4, search(nums1, 0));
        assertEquals(-1, search(nums1, 3));

        assertEquals(3, search(nums2, 2));
        assertEquals(0, search(nums2, 7));
        assertEquals(-1, search(nums2, 9));

        assertEquals(3, search(nums3, 4));
        assertEquals(0, search(nums3, 1));
        assertEquals(-1, search(nums3, 6));

        assertEquals(1, search(nums4, 4));
        assertEquals(5, search(nums4, 1));
        assertEquals(-1, search(nums4, 8));
    }
}
