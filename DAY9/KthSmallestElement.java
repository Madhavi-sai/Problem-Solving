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
    int index;
    int track = 0;
    int element;
    public void inorder(TreeNode root){
        if (root == null)
            return;
        inorder(root.left);
        track += 1;
        if (index == track){
            element = root.val;
        }
        inorder(root.right);   
    }
    public int kthSmallest(TreeNode root, int k) {
        index = k;
        inorder(root);
        return element;
    }
}