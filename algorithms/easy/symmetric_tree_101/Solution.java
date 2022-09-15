package algorithms.easy.symmetric_tree_101;

import algorithms.classes.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return help(root.left, root.right);
    }
    boolean help(TreeNode l,TreeNode r){
        if(l == null && r == null)return true;
        if(l == null || r == null || l.val != r.val) return false;
        return help(l.left,r.right) && help(l.right,r.left);
    }
}
