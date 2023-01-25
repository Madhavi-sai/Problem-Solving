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

    void isSimilar(TreeNode root, List arr){
        if (root == null)
            return;
        isSimilar(root.left, arr);
        isSimilar(root.right, arr);
        if (root.left == null && root.right == null)
            arr.add(root.val);    

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        isSimilar(root1, arr1);
        isSimilar(root2, arr2);
        return arr1.equals(arr2);
    }
}