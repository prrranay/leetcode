class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[nums.length-1],nums[0]);
    }
    public int gcd(int n, int m){
        if(n%m == 0) return m;
        return gcd(m,n%m);
    }
}