class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
		ArrayList<Integer> res = new ArrayList<>();
		bfs(0, visited, res, adj);
		return res;
    }
    
    public static void bfs(int s, boolean[] visited, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj){
		visited[s] = true;
		Queue<Integer>queue=new LinkedList<>();
        queue.add(s);
		while(queue.size() != 0){
			int size = queue.size();
			for (int i = 0; i < size; i++){
				int curr = queue.poll();
				res.add(curr);
				Collections.sort(adj.get(curr));
				for(int neigh: adj.get(curr)){
					if (!visited[neigh]){
						visited[neigh] = true;
						queue.add(neigh);
					}
				}
			}
		}
	}
}