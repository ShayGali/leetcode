package algorithms.classes;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val);
                    if (node.left != null || node.right != null) {
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                } else {
                    sb.append("null");
                }
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }


    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        for (int i = 1; i < values.length; i += 2) {
            TreeNode parent = queue.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (i + 1 < values.length && !values[i + 1].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i + 1]));
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}
