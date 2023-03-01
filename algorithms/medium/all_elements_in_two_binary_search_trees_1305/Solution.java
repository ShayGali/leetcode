package algorithms.medium.all_elements_in_two_binary_search_trees_1305;

import algorithms.classes.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();

        while (root1 != null || root2 != null || !s1.empty() || !s2.empty()) {
            while (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }

            if (s2.isEmpty() || (!s1.isEmpty() && s1.peek().val <= s2.peek().val)) {
                root1 = s1.pop();
                res.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = s2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().getAllElements(TreeNode.deserialize("[2,1,4]"), TreeNode.deserialize("[1,0,3]"));
    }


    //פתרון נאיבי
    /*
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> r1List = new ArrayList<>();
        getList(root1, r1List);
        ArrayList<Integer> r2List = new ArrayList<>();
        getList(root2, r2List);
        return merge(r1List, r2List);
    }

    private List<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        int i = 0, j = 0, l1Size = l1.size(), l2Size = l2.size();
        ArrayList<Integer> res = new ArrayList<>(l2Size + l2Size);

        while (i < l1Size && j < l2Size)
            if (l1.get(i) < l2.get(j)) res.add(l1.get(i++));
            else res.add(l2.get(j++));

        while (i < l1Size) res.add(l1.get(i++));

        while (j < l2Size) res.add(l2.get(j++));

        return res;
    }

    private void getList(TreeNode root2, ArrayList<Integer> list) {
        if (root2 == null) return;
        getList(root2.left, list);
        list.add(root2.val);
        getList(root2.right, list);
    }

     */

}
