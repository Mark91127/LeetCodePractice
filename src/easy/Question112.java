package easy;

import java.util.LinkedList;
import java.util.Queue;

public class Question112 {
    // Version 1 ( 1 ms )
    // Uses BFS to check if any root-to-leaf path sums to targetSum.
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            // Add current node's value to its children.
            if (poll.left != null) {
                poll.left.val += poll.val;
                queue.add(poll.left);
            }
            if (poll.right != null) {
                poll.right.val += poll.val;
                queue.add(poll.right);
            }
            // Check if leaf node sum equals targetSum.
            if (poll.left == null && poll.right == null) {
                if (poll.val == targetSum)
                    return true;
            }
        }
        return false;
    }

    // Version 2 ( recursion ) ( 0 ms )
    // Recursively checks if any root-to-leaf path sums to targetSum.
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        // At leaf node, verify if remaining sum equals node's value.
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        // Subtract current node's value and recurse on children.
        targetSum -= root.val;
        return hasPathSum2(root.left, targetSum) || hasPathSum2(root.right, targetSum);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
