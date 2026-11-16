class Solution {
    public int minMergedInteger(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i = i + 2) {
            int merge = Integer.parseInt(String.valueOf(nums[i]) + String.valueOf(nums[i + 1]));
            min = Math.min(min, merge);
        }

        return min;
    }
}