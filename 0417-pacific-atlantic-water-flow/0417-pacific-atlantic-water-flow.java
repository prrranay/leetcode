class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m= heights.length;
        int n=heights[0].length;

        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(i,0,pacific,heights);
            dfs(i,n-1,atlantic,heights);
        }
        for(int i=0;i<n;i++){
            dfs(0,i,pacific,heights);
            dfs(m-1,i,atlantic,heights);
        }

        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j] ){
                    ans.add(List.of(i,j));
                }
            }
        }
        return ans;
    }
    public void dfs(int row,int col,boolean[][] reach,int[][] heights){
        if(reach[row][col]){
            return;
        }
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};

        reach[row][col]=true;
        for(int[]d:directions){
            int m=row+d[0];
            int n=col+d[1];
            if(m>=0 && m<heights.length && n>=0 && n<heights[0].length && !reach[m][n]){
                if(heights[row][col] <= heights[m][n]){
                    dfs(m,n,reach,heights);
                }
            }
        }
    }
}