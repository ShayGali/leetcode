package algorithms.easy.search_in_a_binary_search_tree_700;

import algorithms.classes.TreeNode;

class Solution {
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val < val)
            return searchBST(root.right,val);
        return searchBST(root.left,val);
    }
  
  public TreeNode searchBSTIterative(TreeNode root, int val) {
            while(root!=null){
                if(root.val==val)
                    return root;
                if(root.val<val)
                    root = root.right;
                else
                    root = root.left;
                
            }
        return null;
    }
}
