class Solution {
    public String longestPalindrome(String s) {
        String res="";
        int n=s.length();

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPali(s,i,j) && (j-i+1) > res.length()){
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    public boolean isPali(String s, int l, int r){
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }

        return true;
    }
}