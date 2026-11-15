class Solution {
    long dp[];
    public long maxDifference(int[] nums) {
        dp=new long[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0);
    }

    public long solve(int[] nums,int i){
        if(nums.length <= i) return 0;
        

        if(dp[i] != -1) return dp[i];
        long sum=(long)nums[i];
        long take1;
        if(sum % 3!=0){
            take1=sum+solve(nums,i+1);
        }else{
            take1=sum-solve(nums,i+1);
        }
        long take2=Long.MIN_VALUE;
        if(i+1<nums.length){
            long sum2=(long)nums[i]+nums[i+1];
            if(sum2%3 == 0){
                take2=sum2-solve(nums,i+2);
            }else{
                take2=sum2+solve(nums,i+2);
            }
        }

        return dp[i]=Math.max(take2,take1);
    }
} 