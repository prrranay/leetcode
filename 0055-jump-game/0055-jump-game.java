class Solution {
    public boolean canJump(int[] nums) {
       boolean dp[]=new boolean[nums.length+1];
       dp[nums.length-1]= true;

       for(int i=nums.length-2;i>=0;i--){
            for(int j=1;j<=nums[i] && (i+j)<nums.length;j++){
                if(dp[i+j]){
                    dp[i]=true;
                }
            }
       }
       return dp[0];
    }
}