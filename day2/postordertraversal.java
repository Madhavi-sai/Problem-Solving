class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return this.arr;
        
    }
    public void postorder(TreeNode root) {
        if (root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
	this.arr.add(root.val);
        
    }
}
