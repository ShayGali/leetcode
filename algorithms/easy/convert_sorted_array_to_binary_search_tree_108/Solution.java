package algorithms.easy.convert_sorted_array_to_binary_search_tree_108;

import algorithms.classes.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        return new TreeNode(
                nums[mid],
                help(nums, start, mid - 1),
                help(nums, mid + 1, end)
        );
    }

}
