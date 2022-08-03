package algorithms.hard._4_median_of_two_sorted_arrays;

public class Solution {
    //O(n)
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] merge = new int[nums1.length + nums2.length];
//        int i = 0, j = 0, k = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] <= nums2[j]) merge[k++] = nums1[i++];
//            else merge[k++] = nums2[j++];
//        }
//        while (i < nums1.length) merge[k++] = nums1[i++];
//        while (j < nums2.length) merge[k++] = nums2[j++];
//
//        if (merge.length % 2 == 0) {
//            return (double) (merge[(merge.length / 2) - 1] + merge[(merge.length / 2)]) / 2;
//        } else {
//            return merge[(merge.length / 2)];
//        }
//    }

    //O(lon n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n1 = 0, n2 = 0;
        while (i < nums1.length && j < nums2.length && i + j <= (nums1.length + nums2.length) / 2) {
            n2 = n1;
            if (nums1[i] <= nums2[j]) {
                n1 = nums1[i++];
            } else {
                n1 = nums2[j++];
            }
        }
        while (i < nums1.length && i + j <= (nums1.length + nums2.length) / 2) {
            n2 = n1;
            n1 = nums1[i++];
        }
        while (j < nums2.length && i + j <= (nums1.length + nums2.length) / 2) {
            n2 = n1;
            n1 = nums2[j++];
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (double) (n1 + n2) / 2;
        } else {
            return n1;
        }
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2};
        int[] n2 = {3,4};
        System.out.println(new Solution().findMedianSortedArrays(n1, n2));
    }
}
