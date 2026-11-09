class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        solve(s,0,new ArrayList<>());
        return ans;
    }

    void solve(String s, int idx,List<String> curr){
        if(s.length() ==  idx){
            ans.add(new ArrayList<>(curr));
            return;
        }


        for(int i=idx;i<s.length();i++){
            if(isPal(s,idx,i)){
                curr.add(s.substring(idx,i+1));
                solve(s,i+1,curr);
                curr.remove(curr.size()-1);
            }
        }
    }


    boolean isPal(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}