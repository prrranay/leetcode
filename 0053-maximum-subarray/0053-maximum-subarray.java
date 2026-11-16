class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int curr=0;

        for(int num:nums){
            if(curr<0){
                curr=0;
            }
            curr+=num;
            max=Math.max(curr,max);
        }

        return max;
    }
}