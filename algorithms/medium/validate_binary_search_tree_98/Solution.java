package algorithms.medium.validate_binary_search_tree_98;

import algorithms.classes.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return help(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean help(TreeNode root, double min, double max) {
        if (root == null) return true;
        return min < root.val && root.val < max &&
                help(root.left, min, root.val) && help(root.right, root.val, max);
    }
}
