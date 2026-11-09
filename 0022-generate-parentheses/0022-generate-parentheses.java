class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve(0,0,n,new StringBuilder());
        return ans;
    }

    void solve(int open,int close,int n,StringBuilder curr){
        if(2*n == curr.length()){
            ans.add(curr.toString());
            return;
        }


        if(open<n){
            curr.append('(');
            solve(open+1,close,n,curr);
            curr.deleteCharAt(curr.length()-1);
        }

        if(close<open){
            curr.append(')');
            solve(open,close+1,n,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}