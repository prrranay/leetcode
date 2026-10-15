class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int occ[]=new int[26];

        for(char c:s.toCharArray()){
            occ[c-'a']++;
        }
        
        for(char c:t.toCharArray()){
            if(occ[c-'a'] == 0){
                return false;
            }
            occ[c-'a']--;
        }

        return true;
    }
}