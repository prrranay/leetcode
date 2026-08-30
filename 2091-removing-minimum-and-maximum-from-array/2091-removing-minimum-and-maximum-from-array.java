class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Remove both from the left
        int removeLeft = right + 1;

        // Remove both from the right
        int removeRight = n - left;

        // Remove one from left and one from right
        int removeBoth = (left + 1) + (n - right);

        return Math.min(removeLeft,
                Math.min(removeRight, removeBoth));
    }
}