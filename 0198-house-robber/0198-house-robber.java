class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,nums.length-1);
    }

    public int solve(int[] nums,int n){
        if(n<0) return 0;
        if(n == 0){
            return nums[n];
        }
        
        if(dp[n] != -1) return dp[n];
        int skip=solve(nums,n-1);
        int take=solve(nums,n-2)+nums[n];

        return dp[n] = Math.max(skip,take);
    }
}