class Solution {
    public String longestPalindrome(String s) {
        String res="";
        int len=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int l=i,r=j;

                while(l<r && s.charAt(l) == s.charAt(r)){
                    l++;
                    r--;
                }

                int curr=j-i+1;
                if(l >=r && curr > len){
                    len=curr;
                    res=s.substring(i,j+1);
                }
            }
        }

        return res;
    }
}