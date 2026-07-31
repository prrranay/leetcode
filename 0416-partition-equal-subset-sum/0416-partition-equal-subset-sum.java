class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%2 != 0) return false;

        int target=totalSum/2;
        boolean dp[]=new boolean[target+1];
        dp[0]=true;

        for(int num:nums){
            for(int i=target-num;i>=0;i--){
                if(dp[i]){
                    dp[i+num]=true;
                }
            }
        }
        return dp[target];
    }
}