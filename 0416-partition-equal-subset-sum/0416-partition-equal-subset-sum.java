class Solution {
    int dp[][];
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum % 2 != 0) return false;
        int n=nums.length;
        dp=new int[n][(sum/2)+1];
        return solve(nums,0,sum/2);
    }

    boolean solve(int[] nums,int i,int target){
        if(i == nums.length){
            return target == 0;
        }

        if(target<0){
            return false;
        }
        if(dp[i][target] != 0){
            if(dp[i][target]==1){
                return false;
            }else{
                return true;
            }
        }
        
        if(solve(nums,i+1,target) || solve(nums,i+1,target-nums[i])){
            dp[i][target]=2;
            return true;
        }else{
            dp[i][target]=1;
            return false;
        }
    }
}