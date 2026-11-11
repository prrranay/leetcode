class Solution {
    public int removeElement(int[] nums, int val) {
        int left=0;
        int k=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right] !=  val){
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left++]=temp;
            }
        }
        return left;
    }
}