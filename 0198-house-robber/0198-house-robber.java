class Solution {
    int[]dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,nums.length-1);
    }

    public int solve(int[] nums,int i){
        if(i==0) return nums[i];
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i];
        int take=solve(nums,i-2)+nums[i];
        int skip=solve(nums,i-1);

        return dp[i]=Math.max(take,skip);
    }
}