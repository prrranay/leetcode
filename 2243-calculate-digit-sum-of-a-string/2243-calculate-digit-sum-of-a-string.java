class Solution {
    public String digitSum(String s, int k) {
        if(s.length() <= k){
            return s;
        }

        StringBuilder sb =new StringBuilder();
        int i=0;
        while(i<s.length()){
            int sum=0;
            int j=i;
            while(j<i+k && j<s.length()){
                int curr=s.charAt(j++)-'0';
                sum+=curr;
            }
            i=j;
            sb.append(String.valueOf(sum));
        }
        return digitSum(sb.toString(),k);
    }
}