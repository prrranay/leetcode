class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        int m=grid.length,n=grid[0].length;
        int fresh=0;

        Queue<int[]> rotten=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j]==2){
                    rotten.offer(new int[]{i,j});
                }
            }
        }

        int minutes=0;
        if(fresh ==0) return 0;
        int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};

        while(!rotten.isEmpty()){
            int size=rotten.size();
            for(int i=0;i<size;i++){
                int[] rot=rotten.poll();

                for(int[] dir:direction){
                    int x=dir[0]+rot[0];
                    int y=dir[1]+rot[1];

                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        fresh--;
                        rotten.offer(new int[]{x,y});
                    }
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes-1:-1;
    }
}