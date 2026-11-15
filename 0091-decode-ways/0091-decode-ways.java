class Solution {
    int n;
    int[] dp;
    public int numDecodings(String s) {
        n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }

    public int solve(String s,int i){
        if(n == i) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];
        int res=solve(s,i+1);

        if(i<n-1){
            if((s.charAt(i) == '1') || (s.charAt(i) == '2' && s.charAt(i+1) <= '6' )){
                res+=solve(s,i+2);
            }
        }
        return dp[i]=res;
    }
}