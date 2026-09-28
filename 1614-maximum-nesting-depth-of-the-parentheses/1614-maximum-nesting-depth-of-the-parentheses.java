class Solution {
    public int maxDepth(String s) {
        Stack<Character> st=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            ans=Math.max(st.size(),ans);

            if(s.charAt(i) == '('){
                st.push('(');
            }
            if(s.charAt(i) == ')'){
                st.pop();
            }
        }
        return ans;
    }
}