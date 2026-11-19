class Solution {
    public int jump(int[] nums) {
        int max=0;
        int end=0;
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            max=Math.max(max,nums[i]+i);
            if(end == i){
                end=max;
                ans++;
            }
        }

        return ans;
    }
}