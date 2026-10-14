class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int len1=word1.length();
        int len2 = word2.length();

        int j=0;
        int k=0;
        for(int i=0;i<len1+len2;i++){
            if(j == len1){
                for(int s=k;s<len2;s++){
                    str.append(word2.charAt(s));
                }
                break;
            }

            if(k == len2){
                for(int s=j;s<len1;s++){
                    str.append(word1.charAt(s));
                }
                break;
            }

            if(i%2 == 0){
                str.append(word1.charAt(j));
                j++;
            }else{
                str.append(word2.charAt(k));
                k++;
            }
        }
        return str.toString();
    }
}