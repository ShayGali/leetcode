package algorithms.medium.find_duplicate_subtrees_652;

import algorithms.classes.TreeNode;

import java.util.*;

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>(); // התוצאה
        HashMap<String, Integer> visited = new HashMap<>(); // איזה תתי עצים כבר ביקרתי וכמה פעמים
        help(root, visited, res); // פונקציית עזר
        return res;
    }

    String help(TreeNode root, HashMap<String, Integer> visited, List<TreeNode> res) {
        if (root == null) return "";
        String left = help(root.left, visited, res); // ייצוג בסטרינג של התת עץ מצד שמאל
        String right = help(root.right, visited, res); // ייצוג בסטרינג של התת עץ מצד ימין
        String curr = root.val + "#" + left + "#" + right; // ייצוג של התת עץ הנוכחי
        Integer visitedOrDefault = visited.getOrDefault(curr, 0); // לבדוק כמה פעמים הוא הופיע, אם הוא לא הופיע אז 0
        if (visitedOrDefault == 1) res.add(root); // אם הוא הופיע כבר פעם אחת אז נוסי, אותו לתוצאה
        visited.put(curr, visitedOrDefault + 1); // נקדם ב1 אם הוא כבר היה או נוסיף אותו למפה
        return curr; // נחזיר את הייצוג של התת עץ הנוכחי
    }
}
