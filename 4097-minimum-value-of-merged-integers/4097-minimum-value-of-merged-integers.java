class Solution {
    public int minMergedInteger(int[] nums) {
        int min=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i=i+2){
            String first=String.valueOf(nums[i]);
            String second=String.valueOf(nums[i+1]);

            int merge=Integer.parseInt(first+second);
            min=Math.min(min,merge);
        }

        return min;
    }
}