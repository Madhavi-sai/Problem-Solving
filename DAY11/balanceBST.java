class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    public void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    public TreeNode constructBST(ArrayList<Integer> arr, int start, int end){
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = constructBST(arr, start, mid - 1);
        node.right = constructBST(arr, mid + 1, end); 
        return node; 
    }

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return constructBST(arr, 0, arr.size() - 1);
    }
}