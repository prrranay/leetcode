class Solution {
    public int maxSubArray(int[] nums) {
        int curr=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            if(curr<0){
                curr=0;
            }
            curr+=num;
            max=Math.max(max,curr);
        }
        return max;
    }
}