class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int ans=0;
                if(i>0) ans+=dp[i-1][j];
                if(j>0) ans+=dp[i][j-1];
                dp[i][j]=ans;
            }
        }
        return dp[m-1][n-1];
    }
}