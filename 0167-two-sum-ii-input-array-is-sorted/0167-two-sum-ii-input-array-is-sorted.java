class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;

        while(left<right){
            int cur=numbers[right]+numbers[left];
            if(target == cur){
                return new int[]{left+1,right+1};
            }else if(target>cur){
                left++;
            }else{
                right--;
            }
        }

        return new int[]{-1,-1};
    }
}