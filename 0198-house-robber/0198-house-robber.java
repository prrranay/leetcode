class Solution {
    public int rob(int[] nums) {
        int rob1=0;
        int rob2=0;
        int max=0;
        for(int num:nums){
            max=Math.max(rob1+num,rob2);
            rob1=rob2;
            rob2=max;
        }
        return max;
    }
}