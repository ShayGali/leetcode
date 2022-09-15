package algorithms.easy.path_sum_112;

import algorithms.classes.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return help(root,targetSum,0);
    }
    boolean help(TreeNode root, int targetSum, int sum){
        if(root == null) return false;
        if(root.left == null && root.right==null)
            return targetSum == sum + root.val;
        return help(root.left,targetSum, sum + root.val) || help(root.right,targetSum, sum + root.val) ;
    }
}
