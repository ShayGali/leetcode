package algorithms.easy.maximum_depth_of_binary_tree_104;

import algorithms.classes.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
