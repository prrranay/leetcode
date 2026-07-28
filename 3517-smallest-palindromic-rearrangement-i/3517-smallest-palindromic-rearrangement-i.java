class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder left = new StringBuilder("");
        StringBuilder mid = new StringBuilder("");

        for(int i=0;i<26;i++){
            char c=(char) ('a'+i);
            for(int j=0;j<count[i]/2;j++){
                left.append(c);
            }
            if(count[i]%2 == 1){
                mid.append(c);
            }
        }
        String right=new StringBuilder(left).reverse().toString();
        return left.toString() + mid + right;
    }
}