class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;

        Arrays.sort(nums);
        int mid=nums[n/2];
        int res=0;
        for(int num:nums){
            res+=Math.abs(num-mid);
        }
        return res;
    }
}