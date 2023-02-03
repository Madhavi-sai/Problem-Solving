class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        class TNode{
            TreeNode node;
            int row, col;
            public TNode (TreeNode node, int row, int col) {
                this.node = node;
                this.row = row;
                this.col = col;
            }
        }   
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<TNode> queue = new LinkedList<>();
        queue.offer(new TNode(root, 0, 0));
        while(queue.size() != 0){
            TNode curr = queue.poll();
            int verti = curr.col;
            int level = curr.row;
            if (!map.containsKey(verti))
                map.put(verti, new TreeMap<>());
				
            if (!map.get(verti).containsKey(level))
                map.get(verti).put(level, new PriorityQueue<Integer>());

            TreeNode Node = curr.node;
            map.get(verti).get(level).offer(Node.val);
            if (Node.left != null)
                queue.offer(new TNode(Node.left, level + 1, verti - 1));
            if (Node.right != null)
                queue.offer(new TNode(Node.right, level + 1, verti + 1)); 
        } 
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> mp : map.values())
		{
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : mp.values())
			{
                while (!pq.isEmpty())
                    ans.get(ans.size() - 1).add(pq.poll());
            }
        }
        return ans;
    }
}
