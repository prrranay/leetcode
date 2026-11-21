class Solution {
    final int INF=Integer.MAX_VALUE;
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        dp=new int[coins.length][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int res=solve(coins,coins.length-1,amount);
        return res < INF ? res : -1;
    }

    public int solve(int[] coins,int i,int amount){
        if(amount == 0){
            return 0;
        }
        if(i<0){
            return INF;
        }
        if(dp[i][amount] != -1) return dp[i][amount];

        int take=INF;

        if(amount>=coins[i]){
            int res=solve(coins,i,amount-coins[i]);
            if(res != INF){
                take=res+1;
            }
        }
        int skip=solve(coins,i-1,amount);
        return dp[i][amount]=Math.min(take,skip);
    }
}