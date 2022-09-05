package algorithms.easy.binary_tree_paths_257;

import algorithms.classes.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.StringBuilder;
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        help(root, l, sb);
        return l;
    }
    
    void help(TreeNode root,List<String> l, StringBuilder sb){
      if(root == null)  return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            l.add(sb.toString());
        } else {
            sb.append("->");
        help(root.left, l, sb);
        help(root.right, l, sb);
    }
    sb.setLength(len);
    }
    
}
