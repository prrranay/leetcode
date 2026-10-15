class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<int[]> rotten=new LinkedList<>();

        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    rotten.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time=0;
        if(fresh == 0) return 0;
        int [][] directions= {{0,1},{1,0},{-1,0},{0,-1}};


        while(!rotten.isEmpty()){
            int size=rotten.size();

            for(int i=0;i<size;i++){
                int[] rot=rotten.poll();

                for(int[] dir:directions){
                    int x=dir[0]+rot[0];
                    int y=dir[1]+rot[1];

                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y] == 1){
                        grid[x][y]=2;
                        fresh--;
                        rotten.offer(new int[]{x,y});
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time-1:-1;
    }
}