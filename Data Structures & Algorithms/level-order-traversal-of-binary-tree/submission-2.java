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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelHeight = q.size();
            for (int i = 0; i < levelHeight; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    currentLevel.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }

            if(currentLevel.size() > 0){
                levels.add(currentLevel);
            }
        }
        return levels;
    }
}
