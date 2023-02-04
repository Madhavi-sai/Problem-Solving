class Solution {
    int track = 0;
    public TreeNode construct(int[] preorder, int limit){
        if (track == preorder.length || preorder[track] > limit)
            return null;
        TreeNode root = new TreeNode(preorder[track++]);
        root.left = construct(preorder, root.val);
        root.right = construct(preorder, limit);
        return root;    
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MAX_VALUE);
    }
}
