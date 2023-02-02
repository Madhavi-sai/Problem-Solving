class Solution {
    int sum = 0;
    public void inorder(TreeNode root, int low, int high){
        if (root == null)
            return;
        inorder(root.left, low, high);
        if (root.val >= low && root.val <= high)
            sum += root.val;
        inorder(root.right, low, high);    
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return sum;
    }
}