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
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return levels;
    }

    public void dfs(TreeNode root, int depth){
        if(root == null){
            return;
        }

        if(levels.size() == depth){
            List<Integer> level = new ArrayList<>();
            level.add(root.val);
            levels.add(level);
        } else {
            levels.get(depth).add(root.val);
        }

        dfs(root.left, depth+1);
        dfs(root.right, depth +1);
    }
}
