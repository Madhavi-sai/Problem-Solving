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
    boolean bool = true;
    int height(TreeNode root){
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            bool = false;
        return Math.max(left, right) + 1;        
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return bool;
    }
}