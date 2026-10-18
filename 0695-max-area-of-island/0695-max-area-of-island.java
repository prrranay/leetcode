class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int area=dfs(grid, i, j);
                max=Math.max(area,max);
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col){
        int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};

        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        grid[row][col]=0;

        int area=1;
        for(int[] dir:directions){
            area+=dfs(grid,row+dir[0],col+dir[1]);
        }

        return area;
    }
}