/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> zipZap = new ArrayList<>();

        if (root == null) {
            return zipZap;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean rightToLeft = false;

        while (!queue.isEmpty()) {
            int queueS = queue.size();

            LinkedList<Integer> currLevel = new LinkedList<>();

            for (int i = 0; i < queueS; i++) {
                TreeNode node = queue.poll();
                if (rightToLeft) {
                    currLevel.addFirst(node.val);
                } else {
                    currLevel.addLast(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            zipZap.add(currLevel);
            rightToLeft = !rightToLeft;

        }

        return zipZap;
    }
}