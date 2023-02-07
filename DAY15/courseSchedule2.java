class Solution {
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
            indegree[u] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                q.add(i);
            }
        }
        int track = 0;
        int[] ans = new int[numCourses];
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[track] = curr;
            track++;
            for (int neigh: adj.get(curr)){
                indegree[neigh] -= 1;
                if (indegree[neigh] == 0)
                    q.add(neigh);
            }
        }
        if (numCourses == track)
            return ans;
        else
            return new int[0];    
    }
}