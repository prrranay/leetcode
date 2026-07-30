class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid[0].length;
        int dp[]=new int[n];
        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i] != 1 && dp[i-1] ==1){
                dp[i]=1;
            }else{
                dp[i]=0;
            }
        }
        
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j]=0;
                }else if(j>0){
                    dp[j]=dp[j]+dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}