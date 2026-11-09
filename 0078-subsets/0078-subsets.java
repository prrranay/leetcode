class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(0,nums,new ArrayList<>());
        return ans;
    }

    void solve(int index,int[] nums,List<Integer> curr){
        if(index >= nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        solve(index+1,nums,curr);
        curr.remove(curr.size()-1);
        solve(index+1,nums,curr);
    }
}