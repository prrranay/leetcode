class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] ans=new int[temps.length];

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<temps.length;i++){

            while(!st.isEmpty()  && temps[i] > temps[st.peek()]){
                int j=st.pop();
                ans[j]=i-j;
            }
            st.push(i);
        }
        return ans;
    }
}