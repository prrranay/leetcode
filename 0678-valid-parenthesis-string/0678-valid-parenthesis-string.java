class Solution {
    public boolean checkValidString(String s) {
        int max=0;
        int min=0;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(c == '('){
                max++;
                min++;
            }else if(c == ')'){
                max--;
                min--;
            }else{
                max++;
                min--;
            }

            if(max < 0){
                return false;
            }

            min=Math.max(0,min);
        }

        return min == 0;
    }
}