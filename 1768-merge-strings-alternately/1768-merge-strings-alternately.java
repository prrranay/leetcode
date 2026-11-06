class Solution {
    public String mergeAlternately(String word1, String word2) {
        int start1=0;
        int start2=0;

        StringBuilder sb=new StringBuilder();
        while(start1 != word1.length() && start2 != word2.length()){
            sb.append(word1.charAt(start1++));
            sb.append(word2.charAt(start2++));
        }

        if(start1 != word1.length()){
            sb.append(word1.substring(start1,word1.length()));
        }
        if(start2 != word2.length()){
            sb.append(word2.substring(start2,word2.length()));
        }

        return sb.toString();
    }
}