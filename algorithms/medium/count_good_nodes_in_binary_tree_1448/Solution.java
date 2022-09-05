package algorithms.medium.count_good_nodes_in_binary_tree_1448;

import algorithms.classes.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return help(root, root.val);
    }
    int help(TreeNode root, int max){
        if(root == null)return 0;
        
        if(root.val >= max)
            return 1 + help(root.left, root.val) + help(root.right, root.val);
        
        return help(root.left, max) + help(root.right, max);
    }
}
