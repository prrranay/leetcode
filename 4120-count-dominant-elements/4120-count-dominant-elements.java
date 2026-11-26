class Solution {
    public int countDominantElements(int[] nums) {
        int n=nums.length;
        if(n == 1) return 1;
        int ans=0;
        for(int i=0;i<n;i++){
            if(i==0){
                if(nums[i] >= nums[i+1]){
                    ans++;
                }
            }else if(i==n-1){
                if(nums[i] >= nums[i-1]){
                    ans++;
                }
            }else{
                int avg=(nums[i+1]+nums[i-1]);
                if(2*nums[i] >= avg){
                    ans++;
                }
            }
        }

        return ans;
    }
}