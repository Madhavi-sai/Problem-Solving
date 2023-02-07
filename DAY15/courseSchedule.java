class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        /*for (int i = 0; i< adj.size(); i++){
            for (int j = 0; j < adj.get(i).size(); j++){
                System.out.println(adj.get(i).get(j));
            }
        }*/

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                q.add(i);
            }
        }
        int track = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            track++;
            for (int neigh: adj.get(curr)){
                indegree[neigh] -= 1;
                if (indegree[neigh] == 0)
                    q.add(neigh);
            }
        }
        return numCourses == track;
    }
}