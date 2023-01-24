class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return this.arr;
        
    }
    public void preorder(TreeNode root) {
        if (root == null){
            return;
        }
        this.arr.add(root.val);
        preorder(root.left);
        preorder(root.right);
        
    }
}
