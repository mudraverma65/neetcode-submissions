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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> curr, int height){
        if(root == null){
            return;
        }

        if(curr.size() == height){
            curr.add(root.val);
        }

        dfs(root.right, curr, height + 1);
        dfs(root.left, curr, height + 1);
    }
}