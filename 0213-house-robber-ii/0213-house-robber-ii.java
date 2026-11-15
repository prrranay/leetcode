class Solution {
    int[][]dp;
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        dp=new int[nums.length][nums.length];
        for(int[] curr:dp){
            Arrays.fill(curr,-1);
        }
        int max1=solve(nums,0,nums.length-2);
        int max2=solve(nums,1,nums.length-1);

        return Math.max(max1,max2);
    }

    public int solve(int[] nums,int start,int i){
        if(i==start) return nums[i];
        if(i<start) return 0;
        if(dp[start][i] != -1) return dp[start][i];
        int take=solve(nums,start,i-2)+nums[i];
        int skip=solve(nums,start,i-1);

        return dp[start][i]= Math.max(take,skip);
    }
}