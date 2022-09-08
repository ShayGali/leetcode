package algorithms.easy.binary_tree_inorder_traversal_94;

import java.util.List;
import java.util.LinkedList;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        help(root,res);
        return res;
    }
    void help(TreeNode r, List<Integer> res){
        if(r==null)return;
        help(r.left,res);
        res.add(r.val);
        help(r.right,res);
    }
}
