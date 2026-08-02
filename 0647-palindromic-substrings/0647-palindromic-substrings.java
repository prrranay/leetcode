class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            ans+=check(i,i,s);
            ans+=check(i,i+1,s);
        }
        return ans;
    }

    public int check(int left,int right, String s){
        int count=0;

        while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}