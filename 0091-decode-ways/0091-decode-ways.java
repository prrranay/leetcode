class Solution {
    HashMap<Integer,Integer> dp=new HashMap<>();
    public int numDecodings(String s) {
        dp.put(s.length(),1);
        return solve(s,0);
    }
    public int solve(String s, int i){
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        if(s.charAt(i) == '0') return 0;


        int res=solve(s,i+1);

        if(i+1 < s.length() &&( s.charAt(i) == '1'  || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
            res+=solve(s,i+2);
        }
        dp.put(i,res);
        return res;
    }
}