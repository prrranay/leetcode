class Solution {
    public int countConsistent(int[] nums) {
        int ans=0;

        for(int i=0;i<nums.length;i++){
            int min=nums[i];
            int sum=nums[i];
            for(int j=i;j<nums.length;j++){
                min=Math.min(nums[j],min);
                sum=sum&nums[j];
                if(sum == min) ans++;
            }
        }
        return ans;
    }
}