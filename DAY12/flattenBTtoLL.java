class Solution {

    LinkedList<TreeNode> ll = new LinkedList<>();
    public void preorder(TreeNode root){
        if (root == null)
            return;
        ll.add(root);
        preorder(root.left);
        preorder(root.right);
    }
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        preorder(root);
        for(int i = 0; i < ll.size() - 1; i++){
            ll.get(i).right = ll.get(i+1);
            ll.get(i).left = null;
        }
        ll.get(ll.size() - 1).right = null;
        ll.get(ll.size() - 1).left = null;

        
    }
}
