class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates,target,0,new ArrayList<>());
        return ans;
    }

    void solve(int[] nums,int target,int start,List<Integer> curr){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0){
            return;
        }


        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            solve(nums,target-nums[i],i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}