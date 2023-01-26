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
    ArrayList<String> arr = new ArrayList<>();
    void treepaths(TreeNode root, String str){
        if (root == null)
            return;
        treepaths(root.left, str + Integer.toString(root.val) + "->") ;
        treepaths(root.right, str  + Integer.toString(root.val) + "->");
        if (root.left == null && root.right == null)
            arr.add(str + Integer.toString(root.val));

    }
    public List<String> binaryTreePaths(TreeNode root) {
        String str = "";
        treepaths(root,str);
        return arr;
    }
}