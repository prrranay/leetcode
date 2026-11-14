class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,n-1),solve(cost,n-2));
    }

    public int solve(int[] cost,int n){
        if(n<0) return 0;
        if(n==0 || n==1) return cost[n];

        if(dp[n] != -1) return dp[n];

        int one=solve(cost,n-1)+cost[n];
        int two=solve(cost,n-2)+cost[n];

        return dp[n] = Math.min(one,two);
    }
}