class Solution {
    int INF=Integer.MAX_VALUE;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(coins,amount,coins.length-1);
        return ans >= INF ? -1 : ans;
    }

    public int solve(int[] coins,int amount,int n){
        if(amount == 0) return 0;
        if(n<0) return INF;

        if(dp[n][amount] != -1) return dp[n][amount];
        int use=INF;
        int skip=solve(coins,amount,n-1);
        if(coins[n] <= amount){
            int result=solve(coins,amount-coins[n],n);
            if(result != INF){
                use=result+1;
            }
        }

        return dp[n][amount]=Math.min(use,skip);
    }
}