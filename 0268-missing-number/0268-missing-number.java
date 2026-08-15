class Solution {
    public int missingNumber(int[] nums) {
        int range=0;
        for(int i=0;i<nums.length+1;i++){
            range^=i;
        }
        int sum=0;
        for(int num:nums){
            sum^=num;
        }

        return range ^ sum;
    }
}