package algorithms.medium.path_sum_II_113;

import algorithms.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        return help(root, 0, targetSum, new ArrayList<>(), new ArrayList<>());
    }

    List<List<Integer>> help(TreeNode root, int targetSum, int target, List<List<Integer>> ans, List<Integer> list) {
        if (root == null) return ans;
        list.add(root.val); // add the current node to the list
        // if the current node is a leaf node and the sum of the path is equal to the target, add the list to the ans
        if (root.left == null && root.right == null && targetSum + root.val == target) {
            ans.add(new ArrayList<>(list));
        }
        // recursively call the left and right subtree
        help(root.left, targetSum + root.val, target, ans, list);
        help(root.right, targetSum + root.val, target, ans, list);
        // remove the last element from the list - backtracking
        list.remove(list.size() - 1);
        // return the ans
        return ans;
    }
}