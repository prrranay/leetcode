class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, solve(nums, i,dp));
        }
        return max;
    }

    public int solve(int[] nums, int i,int[] dp) {
        if (i <= 0) {
            return 1;
        }
        if(dp[i] != -1) return dp[i];
        int best = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                best = Math.max(best, solve(nums, j,dp) + 1);
            }
        }

        return dp[i]=best;
    }
}