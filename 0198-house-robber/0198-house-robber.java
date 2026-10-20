class Solution {
    public int rob(int[] nums) {
        int first=0;
        int second=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int max=Math.max(first+nums[i],second);
            first=second;
            second=max;
            ans=Math.max(ans,Math.max(first,second));
        }

        return ans;
    }
}