class Solution {
    public int numDecodings(String s) {
        int dp[]=new int[s.length()];
        return solve(s,0,dp);
    }

    public int solve(String s,int i,int[] dp){
        if(s.length() == i){
            return 1;
        }

        if(s.charAt(i) == '0') return 0;
        if(dp[i] != 0) return dp[i];

        int one=solve(s,i+1,dp);
        
        if(i<s.length()-1 && (s.charAt(i)=='1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7') )){
            one+=solve(s,i+2,dp);
        }

        return dp[i]=one;
    }
}