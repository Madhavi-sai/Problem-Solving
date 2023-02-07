class Solution {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        visited[0] = true;
        for (int neigh: rooms.get(0)){
            if (!visited[neigh]){
                DFS(neigh, rooms);
            }
        }
        for (int i = 0; i < visited.length; i++){
            if (!visited[i])
                return false;
        }
        return true;
    }

    public void DFS(int s, List<List<Integer>> rooms){
        visited[s] = true;
        for (int neigh: rooms.get(s)){
            if (!visited[neigh]){
                visited[neigh] = true;
                DFS(neigh, rooms);
            }
        }
    }
}