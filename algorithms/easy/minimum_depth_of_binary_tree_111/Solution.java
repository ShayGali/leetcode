package algorithms.easy.minimum_depth_of_binary_tree_111;

import algorithms.classes.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        if (minLeft == 0 && minRight == 0) return 1;
        if (minLeft == 0) return minRight + 1;
        if (minRight == 0) return minLeft + 1;
        return Math.min(minLeft, minRight) + 1;
    }
}
