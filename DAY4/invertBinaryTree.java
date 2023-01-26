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
    TreeNode invert(TreeNode root){
        if (root == null)
            return root;
        TreeNode right = invert(root.left);
        TreeNode left = invert(root.right);
        root.left = left;
        root.right = right;
        return root;    
    }
    public TreeNode invertTree(TreeNode root) {
        TreeNode roo = invert(root);
        return roo;
        
    }
}