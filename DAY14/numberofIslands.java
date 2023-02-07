class pair{
    int row;
    int col;
    pair(int r,int c){
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    BFS(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    public void BFS(int row,int col,char[][] grid,int visited[][]){
        visited[row][col] = 1;
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(row,col));
        int n = grid.length;
        int m = grid[0].length;

        int delRow[] = {-1,1,0,0};
        int delCol[] = {0,0,1,-1};
        while(!q.isEmpty()){
            pair curr = q.poll();
            int nrow = curr.row;
            int ncol = curr.col;
            for(int i=0;i<4;i++){
                int deltaRow=nrow+delRow[i];
                int deltaCol=ncol+delCol[i];

                if(deltaRow>=0 && deltaRow<n && deltaCol>=0 && deltaCol<m && visited[deltaRow][deltaCol]==0 && grid[deltaRow][deltaCol]=='1'){
                    visited[deltaRow][deltaCol] = 1;
                    q.add(new pair(deltaRow,deltaCol));
                }
            }
        }

    }
}