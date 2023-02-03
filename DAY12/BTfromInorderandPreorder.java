class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int preordertrack = 0;
    public TreeNode constructTree(int[] preorder, int left, int right){
        if (left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preordertrack++]);
        root.left = constructTree(preorder, left, map.get(root.val) - 1);
        root.right = constructTree(preorder, map.get(root.val) + 1, right);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return constructTree(preorder, 0, preorder.length - 1);
    }
}
