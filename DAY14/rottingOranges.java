class pair{
    int first;
    int second;
    pair(int f,int s){
        this.first=f;
        this.second=s;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair>q=new LinkedList<pair>();

        int freshOrange=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j));
                }
                if(grid[i][j]==1)
                    freshOrange++;
    
            }
        }
        if (freshOrange == 0)
            return 0;   

        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,-1,1};

    int ans=0;
    int count=0;
    while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0; i < size; i++){
        pair curr = q.poll();

        int col = curr.second;
        int row = curr.first;
        for(int j=0;j<4;j++){
            int nrow=row+delRow[j];
            int ncol=col+delCol[j];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                q.add(new pair(nrow,ncol));
                grid[nrow][ncol]=2;
                count++;
            }
        }
        }
        ans++;

    }
    if(count==freshOrange){
            return ans - 1;
    }
    return -1;

        
    }
}