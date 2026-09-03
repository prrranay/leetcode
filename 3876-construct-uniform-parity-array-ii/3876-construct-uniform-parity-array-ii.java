class Solution {
    public boolean uniformArray(int[] nums) {
        int min=Integer.MAX_VALUE;
        boolean odd=false;
        for(int num:nums){
            min= Math.min(min,num);
            if(num %2 == 1) odd = true;;
        }

        return min % 2 != 0 || !odd;
    }
}