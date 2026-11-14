class Solution {
    final int INF=Integer.MAX_VALUE;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1][coins.length];

        for(int[] curr:dp){
            Arrays.fill(curr,-1);
        }
        solve(coins,amount,coins.length-1);
        return dp[amount][coins.length-1] >= INF ? -1:dp[amount][coins.length-1];
    }


    public int solve(int[] coins,int amount,int n){
        if(amount == 0){
            return dp[amount][n]=0;
        }
        
        if(n<0){
            return INF;
        }

        if(dp[amount][n] != -1) return dp[amount][n];

        int skip=solve(coins,amount,n-1);
        int use=INF;
        if(amount >= coins[n]){
            int resultUse=solve(coins,amount-coins[n],n);
            if(resultUse != INF){
                use=resultUse+1;
            }
        }

        return dp[amount][n]=Math.min(skip,use);
    }
}