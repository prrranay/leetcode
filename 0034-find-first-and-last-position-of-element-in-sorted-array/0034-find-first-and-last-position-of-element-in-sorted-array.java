class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                int first=mid;
                int last=mid;

                while(first>0 && nums[first-1]== target){
                    first--;
                }
                while(last<nums.length-1 && nums[last+1]==target){
                    last++;
                }
                return new int[]{first,last};
            }
        }
        return new int[] { -1, -1 };
    }
}