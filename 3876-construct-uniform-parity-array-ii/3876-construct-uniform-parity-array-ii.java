class Solution {
    public boolean uniformArray(int[] nums) {
        int min=Integer.MAX_VALUE;
        int count=0;
        for(int num:nums){
            min= Math.min(min,num);
            if(num %2 == 1) count++;
        }

        return min % 2 != 0 || count == 0;
    }
}