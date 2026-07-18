class Solution {
    public int findGCD(int[] nums) {
        // Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        return gcd(max,min);
    }
    public int gcd(int n, int m){
        if(n%m == 0) return m;
        return gcd(m,n%m);
    }
}