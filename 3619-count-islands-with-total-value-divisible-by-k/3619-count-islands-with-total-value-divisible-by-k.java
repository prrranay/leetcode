class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0 && dfs(grid,i,j) % k == 0){
                    count++;
                }
            }
        }

        return count;
    }

    public long dfs(int[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        int[][]dirs={{0,1},{1,0},{0,-1},{-1,0}};

        Stack<int[]> st=new Stack<>();
        st.push(new int[]{i,j});
        long value=0;
        while(!st.isEmpty()){
            int[] curr=st.pop();
            int x=curr[0];
            int y=curr[1];

            value+=grid[x][y];
            grid[x][y]=0;

            for(int[] dir:dirs){
                int r=x+dir[0];
                int c=y+dir[1];

                if(r<m && c<n && r >= 0 && c >= 0 && grid[r][c] != 0){
                    st.push(new int[]{r,c});
                }
            }
        }

        return value;
    }
}