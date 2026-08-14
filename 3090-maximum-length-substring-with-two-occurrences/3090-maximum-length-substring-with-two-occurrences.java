class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[]=new int[26];

        int i=0;int j=0;
        int max=0;

        while(j<s.length()){
            char cj=s.charAt(j);
            freq[cj-'a']++;
            while(freq[cj-'a'] > 2){
                char ci=s.charAt(i);
                freq[ci-'a']--;
                i++;
            }

            max= Math.max(max,j-i+1);
            j++;
        }

        return max;
    }
}