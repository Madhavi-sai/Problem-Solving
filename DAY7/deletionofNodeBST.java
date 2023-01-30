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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        TreeNode parent = null;
        TreeNode curr = root;
        while(curr.val != key){
            parent = curr;
            if (key < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
            if (curr == null)
                return root;        
        }

        
        if (curr.left != null && curr.right != null){
            parent = curr;
            TreeNode tempc = curr.left;
            while(tempc.right != null){
                parent = tempc;
                tempc = tempc.right;
            }
            int temp = curr.val;
            curr.val = tempc.val;
            tempc.val = temp;
            curr = tempc;
        }
        if(root.val == curr.val){
            if (root.left != null)
                root = root.left;
            else
                root = root.right; 
            return root;       
        }

        if (parent.left != null && parent.left.val == key){
            if (curr.left != null){
                parent.left = curr.left;
            }
            else{
                parent.left = curr.right;
            }
        } 
        else{
            if (curr.left != null){
                parent.right = curr.left;
            }
            else{
                parent.right = curr.right;
            }
        }  
        return root;        
    }
}