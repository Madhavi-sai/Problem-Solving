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
    int targetsum;
    boolean bool = false;
    void pathSum(TreeNode root, int currSum){
        if (root == null)
            return ;
        System.out.println(root.val + " " + currSum +" " + root.val);    
        if (root.left == null && root.right == null){
            if (currSum == targetsum)
                this.bool = true;
        }
        if (root.left != null)
            pathSum(root.left, currSum + root.left.val);
        if (root.right != null)    
            pathSum(root.right, currSum + root.right.val);    

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        this.targetsum = targetSum;
        pathSum(root, root.val);
        return this.bool;
        
    }
}