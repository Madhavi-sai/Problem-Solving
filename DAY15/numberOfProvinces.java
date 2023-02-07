class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if (!visited[i]){
                count += 1;
                DFS(i, isConnected);
            }
        }
        return count;
    }

    public void DFS(int s, int[][] isConnected){
        visited[s] = true;
        System.out.println(s);
        for (int i = 0; i < isConnected.length; i++){
            if (isConnected[s][i] == 1)
                if(!visited[i]){
                    visited[i] = true;
                    DFS(i, isConnected);
            }
        }
    }


}