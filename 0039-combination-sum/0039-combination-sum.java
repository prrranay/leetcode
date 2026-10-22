class Solution {

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates,target,0,new ArrayList<>());
        return res;
    }

    public void solve(int[] arr,int target, int start, List<Integer> curr){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target< 0){
            return;
        }


        for(int i=start;i<arr.length;i++){
            curr.add(arr[i]);
            solve(arr,target-arr[i],i,curr);
            curr.remove(curr.size()-1);
        }
    }
}