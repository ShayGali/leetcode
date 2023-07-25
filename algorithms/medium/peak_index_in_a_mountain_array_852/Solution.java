package algorithms.medium.peak_index_in_a_mountain_array_852;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    @Test
    void test() {
        int[] arr;
        int expected;
        int actual;

        arr = new int[]{0, 1, 0};
        expected = 1;
        actual = peakIndexInMountainArray(arr);
        assertEquals(expected, actual, String.format("for the array: %s , the index is: %d. need to be: %d", Arrays.toString(arr), actual, expected));

        arr = new int[]{0, 2, 1, 0};
        actual = peakIndexInMountainArray(arr);
        assertEquals(expected, actual, String.format("for the array: %s , the index is: %d. need to be: %d", Arrays.toString(arr), actual, expected));

        arr = new int[]{0, 10, 5, 2};
        actual = peakIndexInMountainArray(arr);
        assertEquals(expected, actual, String.format("for the array: %s , the index is: %d. need to be: %d", Arrays.toString(arr), actual, expected));

        arr = new int[]{2,2,4,9,8,7,6,5,4};
        actual = peakIndexInMountainArray(arr);
        expected = 3;
        assertEquals(expected, actual, String.format("for the array: %s , the index is: %d. need to be: %d", Arrays.toString(arr), actual, expected));
    }
}
