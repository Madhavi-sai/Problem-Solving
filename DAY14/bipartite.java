

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0 && visited[i] == 0) {
                visited[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while(! q.isEmpty()) {
                    int current = q.poll();
                    for (int c: graph[current]) {
                        if (visited[c] == 0) {
                            if (visited[current] == 1)
                                visited[c] = 2;
                            else
                                visited[c] = 1;
                            q.offer(c);
                        }
                        else{
                            if (visited[c] == visited[current])
                                return false;
                        }
                    }
                }                        
                
            }
        }
        
        return true;
    }
}
           