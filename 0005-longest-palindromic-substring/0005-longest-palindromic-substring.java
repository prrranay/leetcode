class Solution {
    int start=0;
    int maxL=0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substring(start,start+maxL);
    }


    public void expand(String s, int left,int right){
        while(right<s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        if(right-left-1 > maxL){
            maxL=right-left-1;
            start=left+1;
        }
    }
}