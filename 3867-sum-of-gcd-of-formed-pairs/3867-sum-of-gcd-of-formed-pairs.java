class Solution {
    public int gcd(int n,int m){
        if(n%m == 0){
            return m;
        }

        return gcd(m,n%m);
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            pre[i]=gcd(nums[i],max);
        }
        Arrays.sort(pre);

        long ans=0;
        for(int i=0;i<n/2;i++){
            ans+=gcd(pre[n-i-1],pre[i]);
        }
        return ans;
    }
}