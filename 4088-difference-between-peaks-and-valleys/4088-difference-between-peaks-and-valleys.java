class Solution {
    public int peakValleyDifference(int[] nums) {
        int peak=0;
        int valley=0;
        for(int i=1;i<nums.length-1;i++){
            int prev=nums[i-1];
            int next=nums[i+1];
            int curr=nums[i];

            if(curr > prev && curr > next){
                peak+=curr;
            }

            if(curr < prev && curr < next){
                valley+=curr;
            }
        }

        return peak-valley;
    }
}