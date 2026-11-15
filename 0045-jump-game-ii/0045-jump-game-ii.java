class Solution {
    int dp[];
    public int jump(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0);
    }

    public int solve(int[] nums,int i){
        if(i>= nums.length-1){
            return 0;
        }
        
        if(dp[i] != -1) return dp[i];
        int min=Integer.MAX_VALUE;

        for(int j=1;j<=nums[i];j++){
            int next=solve(nums,i+j);
            if(next != Integer.MAX_VALUE){
                min=Math.min(min,next+1);
            }
        }

        return dp[i]=min;
    }
}