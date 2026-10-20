class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int first=0;
        int second=0;
        int max1=0;
        for(int i=0;i<nums.length-1;i++){
            max1=Math.max(nums[i]+first,second);
            first=second;
            second=max1;
        }

        first=0;
        second=0;
        int max2=0;
        for(int i=1;i<nums.length;i++){
            max2=Math.max(nums[i]+first,second);
            first=second;
            second=max2;
        }

        return Math.max(max1,max2);
    }
}