class Solution {
    public void sortColors(int[] nums) {
        int fre[]=new int[3];
        for(int num:nums){
            fre[num]++;
        }
        int pos=0;
        for(int i=0;i<fre[0];i++){
            nums[pos]=0;
            pos++;
        }
        for(int i=0;i<fre[1];i++){
            nums[pos]=1;
            pos++;
        }
        for(int i=0;i<fre[2];i++){
            nums[pos]=2;
            pos++;
        }
    }
}