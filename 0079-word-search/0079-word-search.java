class Solution {
    boolean[][] visited;
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;

        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs(char[][] board,String word,int i, int j,int idx){
        if(i>=m || j>=n ||i<0 || j<0) return false;
        if(visited[i][j]) return false;
        if(board[i][j] != word.charAt(idx)) return false;
        if(idx == word.length()-1) return true;

        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        
        visited[i][j]=true;
        for(int[] dir:dirs){
            int r=dir[0]+i;
            int c=dir[1]+j;
            if(dfs(board,word,r,c,idx+1)){
                visited[i][j]=false;
                return true;
            }
        }
                visited[i][j]=false;
        return false;
    }
}