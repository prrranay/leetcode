class Solution {
    public int maxProduct(int[] nums) {
        int max=1;
        int min=1;
        int ans=nums[0];

        for(int num:nums){
            int temp=max*num;
            max=Math.max(Math.max(num,max*num),min*num);
            min=Math.min(Math.min(num,min*num),temp);
            ans=Math.max(ans,Math.max(max,min));
        }
        return ans;
    }
}