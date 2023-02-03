class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        queue.offer(root);
        map.put(root, 1);
        int cur = 1;
        int max = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == 0) 
                    start = map.get(node);
                if(i == size - 1)
                    end = map.get(node);
                if(node.left != null){
                    map.put(node.left, map.get(node) * 2);
                    queue.offer(node.left);
                }
                if(node.right != null){
                    map.put(node.right, map.get(node) * 2 + 1);
                    queue.offer(node.right);
                }
            }
            cur = end - start + 1;
            max = Math.max(cur, max);
        }
        return max;
    }
}
