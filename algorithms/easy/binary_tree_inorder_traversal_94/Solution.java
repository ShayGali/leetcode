package algorithms.easy.binary_tree_inorder_traversal_94;

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

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
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
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
    
     public List<Integer> inorderTraversalIteratively(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !s.isEmpty()){
           
            while(temp!=null){ // the first call - we get to the left 
                s.push(temp);
                temp = temp.left;
            }
            
            temp = s.pop(); // roo == null, so we pop
            
            res.add(temp.val); // inorder
            temp = temp.right; // go right
        }
        return res;
    }
}
