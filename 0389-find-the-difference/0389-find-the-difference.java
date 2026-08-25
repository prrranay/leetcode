class Solution {
    public char findTheDifference(String s, String t) {
        int a=0;
        int b=0;
        for (char c : s.toCharArray()) {
            a+=c;
        }
        for (char c : t.toCharArray()) {
            b+=c;
        }
        return (char) (b-a);
    }
}