class Solution {
    public int dp[]=new int[46];
    public int climbStairs(int n) {
        if(n<=3){
            return n;
        }

        if(dp[n]==0){
            dp[n-1]=climbStairs(n-1);
            dp[n-2]=climbStairs(n-2);
            dp[n]=dp[n-1]+dp[n-2];
        }

        return dp[n];
    }
}