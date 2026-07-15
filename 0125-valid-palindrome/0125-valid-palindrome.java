class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        
        while(l<r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }else if(Character.toLowerCase(s.charAt(r)) != Character.toLowerCase(s.charAt(l))){
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }
}