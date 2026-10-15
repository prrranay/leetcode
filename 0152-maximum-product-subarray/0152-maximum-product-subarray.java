class Solution {
    public int maxProduct(int[] nums) {
        int max=1;
        int min=1; 
        int ans=nums[0];

        for(int num:nums){
            int temp=max*num;
            max=Math.max(num,Math.max(temp,min*num));
            min=Math.min(num,Math.min(temp,min*num));

            ans=Math.max(ans,Math.max(min,max));
        }

        return ans;
    }
}