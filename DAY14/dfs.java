class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    boolean[] visited;
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[V];
        DFS(0, adj);
        return res;
    }
    
    public void  DFS(int s, ArrayList<ArrayList<Integer>> adj){
        visited[s] = true;
        res.add(s);
        for (int neigh: adj.get(s)){
            if (!visited[neigh]){
                DFS(neigh, adj);
            }
        }
    }
}