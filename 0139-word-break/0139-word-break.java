class Solution {
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new int[s.length()+1];
        return solve(s,wordDict,0);
    }

    public boolean solve(String s, List<String> wordDict,int i){
        if(s.length() == i){
            dp[i]=2;
            return true;
        }
        
        if(dp[i] != 0){
            if(dp[i] == 2){
                return true;
            }else{
                return false;
            }
        }
        for(String word:wordDict){
            if(i+word.length() <= s.length() && s.substring(i,i+word.length()).equals(word)){
                if(solve(s,wordDict,i+word.length())){
                    dp[i]=2;
                    return true;
                }
            }
        }
        dp[i]=1;
        return false;
    }
}