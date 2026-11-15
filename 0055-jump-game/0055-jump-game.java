class Solution {
    int dp[];
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        dp=new int[nums.length];
       return solve(nums,0); 
    }

    public boolean solve(int[] nums,int idx){
        if(idx >= nums.length-1){
            return true;
        }

        if(dp[idx] != 0){
            if(dp[idx] == 2){
                return true;
            }else{
                return false;
            }
        }
        for(int i=1;i<=nums[idx];i++){
            if(solve(nums,idx+i)){
                dp[idx]=2;
                return true;
            }
        }
        dp[idx]=1;
        return false;
    }
}