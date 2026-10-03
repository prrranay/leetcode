class Solution {
    public int longestValidParentheses(String s) {
        int maxL=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(!stack.isEmpty()){
                    maxL=Math.max(maxL,i-stack.peek());
                }else{
                    stack.push(i);
                }
            }
        }
        return maxL;
    }
}
