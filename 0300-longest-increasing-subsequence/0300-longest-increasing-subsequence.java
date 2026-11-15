class Solution {
    int dp[];
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,solve(nums,i));
        }
        return max;
    }

    public int solve(int[] nums,int i){
        if(i <= 0){
            return 1;
        }
        
        if(dp[i] != 0) return dp[i];

        int best=1;
        for(int j=0;j<i;j++){
            if(nums[i] > nums[j]){
                best=Math.max(best,solve(nums,j)+1);
            }
        }

        return dp[i]=best;
    }
}