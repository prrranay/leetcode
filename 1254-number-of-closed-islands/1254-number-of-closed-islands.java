class Solution {
    int m;
    int n;
    boolean[][] visit;
    public int closedIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visit=new boolean[m][n];

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0 && !visit[i][j] && bfs(i,j,grid)){
                    count++;
                }
            }
        }

        return count;
    }

    private boolean bfs(int i,int j, int[][] grid){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{i,j});
        visit[i][j]=true;

        boolean isClosed=true;
        int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];

            for(int[] dir:directions){
                int r=x+dir[0];
                int c=y+dir[1];

                if(r<0 || c<0 || r>=m || c>=n){
                    isClosed=false;
                }else if(grid[r][c]==0 && !visit[r][c]){
                    q.offer(new int[]{r,c});
                    visit[r][c]=true;
                }

            }
        }
        return isClosed;
    }
}