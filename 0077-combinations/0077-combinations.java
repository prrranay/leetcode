class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        solve(n,k, 1,new ArrayList<>());
        return  ans;
    }

    void solve(int n, int k, int start,List<Integer> curr){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start;i<=n;i++){
            curr.add(i);
            solve(n,k,i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}