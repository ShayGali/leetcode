package algorithms.easy.balanced_binary_tree_110;

import algorithms.classes.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;// אם האיזון הופר באיזשהו שלב, הערך שיוחזר יהיה מינוס 1
    }

    // הרעיון כאן זה להחזיר את הגובה של כל צומת
    // אם יש הפרה של האיזון נחזיר מינוס 1
    // אם יש הפרה של האיזון באחד מהתתי עצים, גם נחזיר מינוס 1
    // אם האיזון תקין, נחזיר את הגובה של הצומת
    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;

        // לבדוק את האיזון
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // להחזיר את הגובה
        return Math.max(leftHeight, rightHeight)+1;
    }


}
