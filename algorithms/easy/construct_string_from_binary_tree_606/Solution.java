package algorithms.easy.construct_string_from_binary_tree_606;

import algorithms.classes.TreeNode;

public class Solution {
    // with SB
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder(Integer.toString(root.val));
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        // אם אחד מהילדים לא ריק, אז נוסיף את החלק השמאלי
        if (!left.isEmpty() || !right.isEmpty()) sb.append("(").append(left).append(")");
        // נוסיף את החלק הימני רק אם הוא לא ריק
        if (!right.isEmpty()) sb.append("(").append(right).append(")");
        return sb.toString();
    }

    //without SB
    public String tree2str2(TreeNode root) {
        if (root == null) return "";
        String res = root.val + "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if (!left.isEmpty() || !right.isEmpty()) res += "(" + left + ")";
        if (!right.isEmpty()) res += "(" + right + ")";
        return res;
    }
}
