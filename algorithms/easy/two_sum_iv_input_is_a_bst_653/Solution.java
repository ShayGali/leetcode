package algorithms.easy.two_sum_iv_input_is_a_bst_653;

import algorithms.classes.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return help(root, k, new HashSet<>());
    }

    public boolean help(TreeNode node, int k, Set<Integer> visited) {
        if (node == null) {
            return false;
        }
        if (visited.contains(node.val)) return true;
        visited.add(k - node.val);
        return help(node.left, k, visited) || help(node.right, k, visited);
    }
}
