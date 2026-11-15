class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        return solve(m-1,n-1);
    }

    public int solve(int m,int n){
        if(m == 0 && n==0){
            return 1;
        }

        if(dp[m][n] != 0) return dp[m][n];

        int ans=0;
        if(m>0){
            ans+=solve(m-1,n);
        }
        if(n>0){
            ans+=solve(m,n-1);
        }
        return dp[m][n]=ans;
    }
}