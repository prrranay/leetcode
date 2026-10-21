class Solution {
    public int minOperations(String s) {
        boolean sorted=true;
        int n=s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i) < s.charAt(i-1)){
                sorted=false;
                break;
            }
        }

        if(sorted) return 0;
        if(n == 2) return -1;

        char max=s.charAt(0);
        char min=s.charAt(0);

        for(int i=1;i<n;i++){
            char c=s.charAt(i);
            if(c > max){
                max=c;
            }
            if(c < min){
                min=c;
            }
        }

        if(min == s.charAt(0) || max == s.charAt(n-1)) return 1;

        for(int i=1;i<n-1;i++){
            char c=s.charAt(i);

            if(c == min || c == max) return 2;
        }

        return 3;
    }
}