class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates,target,0,new ArrayList<>());
        return ans;
    }

    public void solve(int[] arr,int target,int i,List<Integer> curr){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i == arr.length) return;

        if(target<0){
            return;
        }

        curr.add(arr[i]);
        solve(arr,target-arr[i],i,curr);
        curr.remove(curr.size()-1);
        solve(arr,target,i+1,curr);
    }
}