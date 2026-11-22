class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        dp=new int[m][n];
        for(int[] curr:dp){
            Arrays.fill(curr,-1);
        }
        return solve(text1,text2,m-1,n-1);
    }

    public int solve(String s1, String s2, int m, int n){
        if(m == -1 || n == -1){
            return 0;
        }

        if(dp[m][n] != -1) return dp[m][n];

        if(s1.charAt(m) == s2.charAt(n)){
            return dp[m][n]=solve(s1,s2,m-1,n-1)+1;
        }else{
            int left=solve(s1,s2,m,n-1);
            int right=solve(s1,s2,m-1,n);

            return dp[m][n]=Math.max(left,right);
        }
    }
}