class Solution {
    int prev = 0;
    public void inorder(TreeNode root){
        if (root == null)
            return;
        inorder(root.right);
        root.val += prev;
        prev = root.val;
        inorder(root.left);    
    }
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }
}