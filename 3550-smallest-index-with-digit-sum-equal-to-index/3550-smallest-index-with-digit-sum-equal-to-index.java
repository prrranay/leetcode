class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int s=sum(nums[i]);
            if(s==i){
                return s;
            }
        }
        return -1;
    }
    int sum(int num){
        int sum=0;
        while(num>0){
            int dig=num%10;
            sum+=dig;
            num/=10;
        }
        return sum;
    }
}