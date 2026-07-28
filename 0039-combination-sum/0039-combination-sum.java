class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates,0,target,new ArrayList<>());
        return res;
    }
    public void solve(int[] arr,int start, int target,List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i=start;i<arr.length;i++){
            list.add(arr[i]);
            solve(arr,i,target-arr[i],list);
            list.remove(list.size()-1);
        }
    }
}