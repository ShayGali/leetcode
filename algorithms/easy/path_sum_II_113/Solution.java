package algorithms.easy.path_sum_II_113;

import java.util.List;
import java.util.ArrayList;

import algorithms.classes.TreeNode;

// ArrayList -> 2 ms, LinkedList -> 4ms

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(root,targetSum,0,res,temp);
        return res;
    }
    
    void help(TreeNode root, int targetSum, int sum, List<List<Integer>> res, List<Integer> temp){
        if(root == null) return;
        if(root.left == null && root.right==null){
            if(targetSum == sum + root.val){
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
        }
        temp.add(root.val);
        help(root.left,targetSum, sum + root.val,res,temp);
        help(root.right,targetSum, sum + root.val,res,temp);
        temp.remove(temp.size()-1);
    }
}
