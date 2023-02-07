class Solution {
    class Pair{
        int col;
        int row;
        public Pair(int r, int c){
            col = c;
            row = r;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int m = image.length;
        int n = image[0].length;
        int scolor = image[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        int[] rowSet = {1,0,-1,0};
        int[] colSet = {0,1,0,-1};
        q.add(new Pair(sr, sc));
        image[sr][sc] = color;
        int count = 0;
        while(q.size() != 0){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            for (int i = 0; i < 4; i++){
                int srow = row + rowSet[i];
                int scol = col + colSet[i];
                if (srow >= 0 && srow < m && scol >= 0 && scol < n && image[srow][scol] == scolor){
                    q.add(new Pair(srow, scol));
                    image[srow][scol] = color;
                }
            }
        }
        return image;
    }
}