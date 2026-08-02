class Solution {
    public boolean stoneGame(int[] piles) {
         int n = piles.length;
        if ((n & 1) == 0) return true;

        Integer[][] dp = new Integer[n][n];
        return maxDiff(0, n - 1, piles, dp) >= 0;
    }
    int maxDiff(int i, int j, int[] nums,Integer[][] dp){
        if(dp[i][j] != null) return dp[i][j];
        if(i == j) return dp[i][j] =nums[i];

        return dp[i][j]= Math.max(nums[i]-maxDiff(i+1,j,nums,dp),nums[j] - maxDiff(i,j-1,nums,dp));
    }
}